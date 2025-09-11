# 1052. Grumpy Bookstore Owner

https://leetcode.com/problems/grumpy-bookstore-owner/

## Problem Description

A bookstore owner has a list of customers who visit the store during certain minutes. The owner has a grumpy period during which they are unable to satisfy customers. You are given two lists:

- `customers`: An integer array where `customers[i]` is the number of customers that arrived at the `i`-th minute.
- `grumpy`: A binary array where `grumpy[i]` is `1` if the owner is grumpy at the `i`-th minute, and `0` otherwise.

The owner can choose to be grumpy for at most `X` consecutive minutes. Your task is to determine the maximum number of customers that can be satisfied if the owner chooses to be grumpy for at most `X` consecutive minutes.

### Example 1:
**Input:**  
`customers = [1,0,1,2,1,1,7,5]`  
`grumpy = [0,1,0,1,0,1,0,1]`  
`X = 3`

**Output:**  
`16`

**Explanation:**  
The maximum number of customers that can be satisfied is `16`. This can be achieved by making the owner grumpy during minutes `2` to `4`, which allows satisfying customers at minutes `2`, `3`, and `4`.

### Constraints:
- `1 <= customers.length == grumpy.length <= 2 * 10^4`
- `0 <= customers[i] <= 1000`
- `0 <= grumpy[i] <= 1`
- `1 <= X <= customers.length`
