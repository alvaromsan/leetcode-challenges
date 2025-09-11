# 66. Plus One

https://leetcode.com/problems/plus-one/description/

## Problem Description

You are given a large integer represented as an integer array `digits`, where each `digits[i]` is the `i`-th digit of the integer.

The digits are stored such that the most significant digit is at the head of the list, and each element in the array contains a single digit.

Add one to the integer represented by the array. Return the resulting array of digits.

---

## Example 1

**Input:**

```text
digits = [1, 2, 3]
```

**Output:**

```text
[1, 2, 4]
```

**Explanation:**  
The integer represented by `digits` is 123. Adding one gives 124. Thus, the result should be `[1, 2, 4]`.

---

## Example 2

**Input:**

```text
digits = [9, 9, 9]
```

**Output:**

```text
[1, 0, 0, 0]
```

**Explanation:**  
The integer represented by `digits` is 999. Adding one gives 1000. Thus, the result should be `[1, 0, 0, 0]`.

---

## Constraints

- `1 <= digits.length <= 100`
- `0 <= digits[i] <= 9`
- `digits` does not contain any leading zeros, except the number 0 itself.
