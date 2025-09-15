# 3541. Find Most Frequent Vowel and Consonant

https://leetcode.com/problems/find-most-frequent-vowel-and-consonant/description/

## Problem

Given a string `s`, find the vowel (one of `'a'`, `'e'`, `'i'`, `'o'`, or `'u'`) with the maximum frequency. Find the consonant (all other letters excluding vowels) with the maximum frequency. Return the indices of the vowel and consonant in the string.

If there are multiple vowels or consonants with the same maximum frequency, return the one that appears first in the string.

### Example 1:

**Input:**
```python
s = "abacabad"
```

**Output:**
```python
(1, 0)
```

**Explanation:**
- The most frequent vowel is `'a'` with a frequency of 4. Its first occurrence is at index 1.
- The most frequent consonant is `'b'` with a frequency of 2. Its first occurrence is at index 0.

### Example 2:

**Input:**
```python
s = "aeiou"
```

**Output:**
```python
(0, 1)
```

**Explanation:**
- The most frequent vowel is `'a'` with a frequency of 1. Its first occurrence is at index 0.
- The most frequent consonant is `'e'` with a frequency of 1. Its first occurrence is at index 1.

### Constraints:
- `1 <= s.length <= 1000`
- `s` consists of lowercase English letters.
