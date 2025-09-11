# 3021. Alice and Bob Playing Flower Game

https://leetcode.com/problems/alice-and-bob-playing-flower-game/description/

## Problem Description

Alice and Bob are playing a turn-based game on a field, with two lanes of flowers between them. There are `x` flowers in the first lane between Alice and Bob, and `y` flowers in the second lane between them. The game proceeds as follows:

- Alice and Bob take turns, starting with Alice.
- On each turn, the current player must remove one flower from one of the two lanes.
- The game ends when there are no flowers left in either lane.

The goal is to determine who will win the game, assuming both players play optimally.

### Example 1:
**Input:**  
`x = 3, y = 4`

**Output:**  
`Alice`

**Explanation:**
- Alice removes one flower from the first lane, leaving `x = 2, y = 4`.
- Bob removes one flower from the second lane, leaving `x = 2, y = 3`.
- Alice removes one flower from the first lane, leaving `x = 1, y = 3`.
- Bob removes one flower from the second lane, leaving `x = 1, y = 2`.
- Alice removes one flower from the first lane, leaving `x = 0, y = 2`.
- Bob removes one flower from the second lane, leaving `x = 0, y = 1`.
- Alice removes one flower from the second lane, leaving `x = 0, y = 0`.

Since Alice made the last move, she wins.

### Example 2:
**Input:**  
`x = 2, y = 3`

**Output:**  
`Bob`

**Explanation:**
- Alice removes one flower from the first lane, leaving `x = 1, y = 3`.
- Bob removes one flower from the second lane, leaving `x = 1, y = 2`.
- Alice removes one flower from the first lane, leaving `x = 0, y = 2`.
- Bob removes one flower from the second lane, leaving `x = 0, y = 1`.
- Alice removes one flower from the second lane, leaving `x = 0, y = 0`.

Since Bob made the last move, he wins.

### Constraints:
- `1 <= x, y <= 1000`
