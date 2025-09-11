# 945. Minimum Increment to Make Array Unique

https://leetcode.com/problems/minimum-increment-to-make-array-unique/description/

## Problem Description

Given an integer array `nums`, return the minimum number of moves required to make every value in `nums` unique.

In one move, you can increment any element of the array by 1.

### Example 1:
**Input:** `nums = [1,2,2]`  
**Output:** `1`  
**Explanation:** After 1 move, the array could be `[1, 2, 3]`.

### Example 2:
**Input:** `nums = [3,2,1,2,1,7]`  
**Output:** `6`  
**Explanation:** After 3 moves, the array could be `[3, 4, 1, 2, 5, 7]`.

### Example 3:
**Input:** `nums = [1,2,3]`  
**Output:** `0`  
**Explanation:** No moves are needed as all elements are unique.

### Constraints:
- `1 <= nums.length <= 10^4`
- `0 <= nums[i] <= 10^4`
