# 35. Search Insert Position

https://leetcode.com/problems/search-insert-position/description/

## Problem Description

Given a sorted array of distinct integers `nums` and a target value `target`, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You must solve it in O(log(n)) time complexity.

### Example 1:
**Input:** `nums = [1,3,5,6], target = 5`  
**Output:** `2`

### Example 2:
**Input:** `nums = [1,3,5,6], target = 2`  
**Output:** `1`

### Example 3:
**Input:** `nums = [1,3,5,6], target = 7`  
**Output:** `4`

### Example 4:
**Input:** `nums = [1,3,5,6], target = 0`  
**Output:** `0`

### Example 5:
**Input:** `nums = [1], target = 0`  
**Output:** `0`

### Constraints:
- `1 <= nums.length <= 10^4`
- `-10^4 <= nums[i] <= 10^4`
- `nums` is sorted in **ascending order** and does not contain duplicates.
- `-10^4 <= target <= 10^4`
