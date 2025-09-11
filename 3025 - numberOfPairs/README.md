# 3025. Find the Number of Ways to Place People I

https://leetcode.com/problems/find-the-number-of-ways-to-place-people-i/description/

## Problem Description

You are given a 2D array `points` of size `n x 2` representing integer coordinates of some points on a 2D plane, where `points[i] = [x_i, y_i]`. Count the number of distinct ways to place `n` people on the plane such that no two people share the same position.

### Example 1:
**Input:**  
`points = [[1, 1], [2, 2], [3, 3]]`

**Output:**  
`6`

**Explanation:**  
There are 6 distinct ways to place 3 people on the plane without any two sharing the same position.

### Example 2:
**Input:**  
`points = [[1, 1], [1, 1], [1, 1]]`

**Output:**  
`1`

**Explanation:**  
All points are the same, so there is only 1 way to place the people.

### Constraints:
- `1 <= points.length <= 1000`
- `-10^4 <= x_i, y_i <= 10^4`
- All points are distinct.
