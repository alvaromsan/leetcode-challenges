# 27. Remove Element

https://leetcode.com/problems/remove-element/description/

## Problem Description

Given an integer array `nums` and an integer `val`, remove all occurrences of `val` in `nums` **in-place**. The order of the elements may be changed. Then return the number of elements in `nums` that are not equal to `val`.

Consider the number of elements in `nums` that are not equal to `val` as the **new length** of the array.

Do not allocate extra space for another array. You must do this by modifying the input array **in-place** with O(1) extra memory.

### Example 1:
**Input:** `nums = [3,2,2,3], val = 3`  
**Output:** `2, nums = [2,2,_,_]`  
**Explanation:** Your function should return `k = 2`, with the first two elements of `nums` being `2`. It does not matter what you leave beyond the returned `k` (hence they are underscores).

### Example 2:
**Input:** `nums = [0,1,2,2,3,0,4,2], val = 2`  
**Output:** `5, nums = [0,1,4,0,3,_,_,_]`  
**Explanation:** Your function should return `k = 5`, with the first five elements of `nums` being `0`, `1`, `4`, `0`, and `3`. Note that `nums` is passed in by reference, so your solution should modify the input array in-place.

### Constraints:
- `0 <= nums.length <= 100`
- `0 <= nums[i] <= 50`
- `0 <= val <= 100`
