# 1552. Magnetic Force Between Two Balls

https://leetcode.com/problems/magnetic-force-between-two-balls/description/

## Problem Description

In the universe Earth C-137, Rick discovered a special form of magnetic force between two balls if they are put in his new invented basket.

Given an integer array `position` where `position[i]` represents the position of the `i`-th ball, and an integer `m` which represents the number of balls to put in the basket, return the **maximum** magnetic force between any two balls that are put into the basket.

The magnetic force between two balls at positions `x` and `y` is defined as `|x - y|`.

### Example 1:
**Input:** `position = [1, 2, 3, 4, 7], m = 3`  
**Output:** `3`  
**Explanation:** We can put balls at positions 1, 4, and 7 to have a magnetic force of 3 between the balls.

### Example 2:
**Input:** `position = [5, 4, 3, 2, 1, 1000000000], m = 2`  
**Output:** `999999999`  
**Explanation:** We can put balls at positions 1 and 1000000000 to have a magnetic force of 999999999 between the balls.

### Constraints:
- `2 <= position.length <= 100`
- `1 <= position[i] <= 10^9`
- All values of `position` are distinct.
- `2 <= m <= position.length`
