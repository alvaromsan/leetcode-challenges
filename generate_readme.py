import os
import re
import urllib.parse  # for URL encoding

# Path to your LeetCode repo
repo_path = "."  # current directory
output_file = "README.md"

# Folders to ignore
ignore_folders = {"venv", ".git", "__pycache__"}

# Store problem info as tuples: (number, name, folder)
problems = []

for folder in os.listdir(repo_path):
    if folder in ignore_folders:
        continue  # skip ignored folders
    folder_path = os.path.join(repo_path, folder)
    readme_path = os.path.join(folder_path, "README.md")
    if os.path.isdir(folder_path) and os.path.exists(readme_path):
        with open(readme_path, "r", encoding="utf-8") as f:
            first_line = f.readline().strip()
            # Match pattern: # number. Name
            match = re.match(r'#\s*(\d+)\.\s*(.+)', first_line)
            if match:
                number = int(match.group(1))
                name = match.group(2).strip()
                problems.append((number, name, folder))
            else:
                # fallback: use folder name and put at the end
                problems.append((float('inf'), folder, folder))

# Sort problems by number
problems.sort(key=lambda x: x[0])

# Write main README
with open(output_file, "w", encoding="utf-8") as f:
    f.write("# LeetCode Java Solutions Repository\n\n")
    f.write("This repository contains solutions to a wide range of algorithm and data structure problems from [LeetCode](https://leetcode.com/). ")
    f.write("All problems are solved using **Java**. Each folder contains the problem solution and a README with the problem description.\n\n")

    f.write("## Table of Contents\n\n")
    for number, name, folder in problems:
        # URL encode folder name for spaces and special characters
        encoded_folder = urllib.parse.quote(folder)
        link_text = f"{number}. {name}" if number != float('inf') else name
        f.write(f"- [{link_text}]({encoded_folder}/README.md)\n")

print(f"README.md generated with {len(problems)} problems.")
