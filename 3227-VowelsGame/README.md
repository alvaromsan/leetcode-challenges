# 3227. Vowels Game in a String

https://leetcode.com/problems/vowels-game-in-a-string/description/

## Problem Description

Alice and Bob are playing a game with a string `s`. The game starts with Alice, and they alternate turns. On each player's turn, they must remove a non-empty substring from `s` that contains an **odd number of vowels**. The player who cannot make a move loses the game.

- Alice plays first.
- A substring is a contiguous sequence of characters within a string.
- A vowel is one of the following characters: `'a'`, `'e'`, `'i'`, `'o'`, `'u'`.

Return the winner of the game. If Alice wins, return `"Alice"`. Otherwise, return `"Bob"`.

### Example 1

**Input:**

```plaintext
s = "aeiou"
```

**Output:**

```plaintext
"Alice"
```

**Explanation:**

- Alice removes `"aei"` (odd number of vowels).
- Bob removes `"o"` (odd number of vowels).
- Alice removes `"u"` (odd number of vowels).
- Bob cannot make a move, so Alice wins.

### Example 2

**Input:**

```plaintext
s = "leetcode"
```

**Output:**

```plaintext
"Bob"
```

**Explanation:**

- Alice removes `"e"` (odd number of vowels).
- Bob removes `"e"` (odd number of vowels).
- Alice removes `"o"` (odd number of vowels).
- Bob removes `"e"` (odd number of vowels).
- Alice removes `"e"` (odd number of vowels).
- Bob cannot make a move, so Alice wins.

### Constraints

- `1 <= s.length <= 1000`
- `s` consists of lowercase English letters
