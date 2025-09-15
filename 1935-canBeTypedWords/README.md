# 1935. Maximum Number of Words You Can Type

https://leetcode.com/problems/maximum-number-of-words-you-can-type/description/

## Problem Description

Given a string `text` of words separated by a single space (no leading or trailing spaces) and a string `brokenLetters` of all distinct letter keys that are broken, return the maximum number of words in `text` that you can type using only the available keys.

### Example 1:

**Input:**

```python
text = "hello world"
brokenLetters = "ad"
```

**Output:**

```python
1
```

**Explanation:**

We can type "hello" and "world" using the available keys, but "world" contains the broken letter "o", so we cannot type it. Therefore, the maximum number of words we can type is 1.

### Example 2:

**Input:**

```python
text = "leet code"
brokenLetters = "lt"
```

**Output:**

```python
1
```

**Explanation:**

We can type "leet" and "code" using the available keys, but "leet" contains the broken letter "t", so we cannot type it. Therefore, the maximum number of words we can type is 1.

### Constraints:

- 1 <= text.length <= 1000
- 0 <= brokenLetters.length <= 26
- `text` consists of words separated by a single space.
- `brokenLetters` consists of distinct lowercase English letters.
