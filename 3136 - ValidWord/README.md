# 3136. Valid Word

https://leetcode.com/problems/valid-word/description/

## Problem Description

A word is considered valid if:

- It contains a minimum of 3 characters.
- It contains only digits (`0-9`) and English letters (uppercase and lowercase).

### Example 1:
**Input:**  
`word = "abc123"`

**Output:**  
`true`

**Explanation:**  
The word contains 6 characters and only includes letters and digits.

### Example 2:
**Input:**  
`word = "ab"`

**Output:**  
`false`

**Explanation:**  
The word contains only 2 characters, which is less than the minimum required.

### Example 3:
**Input:**  
`word = "abc!"`

**Output:**  
`false`

**Explanation:**  
The word contains 4 characters but includes an invalid character (`!`).

### Constraints:
- `1 <= word.length <= 100`
- `word` consists of only English letters (uppercase and lowercase) and digits (`0-9`).
