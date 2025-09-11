# 1733. Minimum Number of People to Teach

https://leetcode.com/problems/minimum-number-of-people-to-teach/description/

## Problem Description

There are `n` people in a social network. Each person has a list of languages they know. You need to determine the minimum number of people to teach a new language so that everyone in the network can communicate with each other.

You are given:

- `n`: The number of people in the network.
- `languages`: A list of lists where each inner list represents the languages known by a person.

Return the minimum number of people you need to teach a new language so that everyone can communicate with each other.

### Example 1:
**Input:**  
`n = 5`  
`languages = [[1, 2], [2, 3], [3, 4], [4, 5], [5, 6]]`

**Output:**  
`1`

**Explanation:**  
Teaching person 1 language 3 allows all people to communicate.

### Example 2:
**Input:**  
`n = 3`  
`languages = [[1], [2], [3]]`

**Output:**  
`3`

**Explanation:**  
Each person knows a different language, so we need to teach each person a new language to enable communication.

### Constraints:
- `1 <= n <= 100`
- `1 <= languages[i].length <= 100`
- `1 <= languages[i][j] <= 1000`
- All elements in `languages[i]` are distinct.
