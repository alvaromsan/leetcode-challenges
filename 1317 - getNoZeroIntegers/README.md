# 1317. Convert Integer to the Sum of Two No-Zero Integers

https://leetcode.com/problems/convert-integer-to-the-sum-of-two-no-zero-integers/

## Problem Description

Given an integer `n`, return a list of two integers `[a, b]` such that:

- `a + b = n`
- `a` and `b` are **positive integers**.
- Neither `a` nor `b` contain the digit `0` in their decimal representation.

### Example 1:
**Input:** `n = 11`  
**Output:** `[2, 9]`  
**Explanation:** `2 + 9 = 11`, and neither `2` nor `9` contains the digit `0`.

### Example 2:
**Input:** `n = 1000000000`  
**Output:** `[999999997, 3]`  
**Explanation:** `999999997 + 3 = 1000000000`, and neither `999999997` nor `3` contains the digit `0`.

### Constraints:
- `1 <= n <= 10^9`
