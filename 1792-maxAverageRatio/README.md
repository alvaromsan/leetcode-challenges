# 1792. Maximum Average Pass Ratio

https://leetcode.com/problems/maximum-average-pass-ratio/description/

## Problem Description

There are `n` classes in a school. You are given two integer arrays `pass` and `total` of length `n`, where:

- `pass[i]` is the number of students who passed the `i`-th class.
- `total[i]` is the total number of students in the `i`-th class.

Initially, the average pass ratio is the sum of `pass[i] / total[i]` for all `i` divided by `n`.

You can increase the pass ratio of a class by increasing the number of students who pass the class. You can perform this operation at most `k` times, and each operation increases the pass ratio of a class by `1 / total[i]`.

Return the maximum possible average pass ratio after performing at most `k` operations.

### Example 1:
**Input:**  
`pass = [1, 2, 3], total = [2, 3, 4], k = 2`

**Output:**  
`0.78333`

**Explanation:**  
We can increase the pass ratio of the second class by 1, and the pass ratio of the third class by 1, resulting in a maximum average pass ratio of approximately 0.78333.

### Constraints:
- `n == pass.length == total.length`
- `1 <= n <= 100`
- `1 <= pass[i] <= total[i] <= 100`
- `1 <= k <= 100`
