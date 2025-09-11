# 21. Merge Two Sorted Lists

https://leetcode.com/problems/merge-two-sorted-lists/description/

## Problem Description

You are given the heads of two sorted linked lists, `l1` and `l2`. Merge the two lists into one **sorted linked list**. The list should be made by **splicing together the nodes** of the first two lists.

### Example 1:
**Input:** `l1 = [1,2,4]`, `l2 = [1,3,4]`  
**Output:** `[1,1,2,3,4,4]`

### Example 2:
**Input:** `l1 = []`, `l2 = []`  
**Output:** `[]`

### Example 3:
**Input:** `l1 = []`, `l2 = [0]`  
**Output:** `[0]`

### Constraints:
- The number of nodes in both lists is in the range `[0, 1000]`.
- `-1000 <= Node.val <= 1000`
- Both `l1` and `l2` are sorted in **non-decreasing order**.
