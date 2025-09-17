# 966. Vowel Spellchecker

https://leetcode.com/problems/vowel-spellchecker/description/

## Problem Description

Given a list of `words` and a list of `queries`, you need to implement a spell checker that converts each query into a correct word in the following way:

1. If the query exactly matches a word in the dictionary (case-sensitive), then the query is correct.
2. If the query matches a word in the dictionary after converting all vowels (`'a'`, `'e'`, `'i'`, `'o'`, `'u'`) to lowercase, then the query is correct.
3. If the query matches a word in the dictionary after converting all vowels to uppercase, then the query is correct.

Return a list of the correct words for each query.

### Example 1:

**Input:**
```python
words = ["KiTe","kite","hare","Hare"]
queries = ["kite","Kite","KiTe","Hare","HARE","Hear","hear","keti","keet","keto"]
```

**Output:**
```python
["kite","KiTe","KiTe","Hare","hare","","hare","KiTe","","KiTe"]
```

**Explanation:**
- "kite" matches exactly with "kite" in the dictionary.
- "Kite" matches exactly with "KiTe" in the dictionary.
- "KiTe" matches exactly with "KiTe" in the dictionary.
- "Hare" matches exactly with "Hare" in the dictionary.
- "HARE" matches "hare" in the dictionary after converting all vowels to lowercase.
- "Hear" does not match any word in the dictionary.
- "hear" matches "hare" in the dictionary after converting all vowels to lowercase.
- "keti" matches "KiTe" in the dictionary after converting all vowels to uppercase.
- "keet" matches "KiTe" in the dictionary after converting all vowels to uppercase.
- "keto" matches "KiTe" in the dictionary after converting all vowels to uppercase.

### Constraints:
- `1 <= words.length, queries.length <= 1000`
- `1 <= words[i].length, queries[i].length <= 100`
- `words[i]` and `queries[i]` consist of only lowercase and uppercase English letters.
