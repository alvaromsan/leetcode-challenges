import os
import re

# Use the current working directory
repo_path = os.getcwd()

# Regex to match folder starting with a number, optional spaces around hyphen
pattern = re.compile(r'^(\d+)\s*-\s*(.+)$')

# First, find the maximum number to determine padding
max_number = 0
for folder in os.listdir(repo_path):
    folder_path = os.path.join(repo_path, folder)
    if os.path.isdir(folder_path):
        match = pattern.match(folder)
        if match:
            number = int(match.group(1))
            if number > max_number:
                max_number = number

# Determine padding dynamically (enough digits for the largest number)
pad_digits = len(str(max_number))

# Now rename folders
for folder in os.listdir(repo_path):
    folder_path = os.path.join(repo_path, folder)

    if os.path.isdir(folder_path):
        match = pattern.match(folder)
        if match:
            number = int(match.group(1))
            rest = match.group(2)

            new_name = f"{number:0{pad_digits}}-{rest}"  # no spaces
            new_path = os.path.join(repo_path, new_name)

            if folder != new_name:
                print(f"Renaming '{folder}' -> '{new_name}'")
                os.rename(folder_path, new_path)
