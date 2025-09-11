# 2327. Number of People Aware of a Secret

https://leetcode.com/problems/number-of-people-aware-of-a-secret/description/

## Problem Description

On day 1, one person discovers a secret. You are given an integer `delay`, which means that each person will share the secret with a new person every day, starting from the day they discover it. You are also given an integer `forget`, which means that each person will forget the secret after `forget` days.

Return the number of people who know the secret at the end of `days` days. Since the answer may be large, return it modulo 10^9 + 7.

### Example 1:
**Input:**  
`n = 4, delay = 2, forget = 3, days = 6`

**Output:**  
`5`

**Explanation:**
- Day 1: Person 1 discovers the secret.
- Day 2: Person 1 shares the secret with Person 2.
- Day 3: Person 1 shares the secret with Person 3.
- Day 4: Person 1 shares the secret with Person 4.
- Day 5: Person 2 forgets the secret.
- Day 6: Person 3 forgets the secret.

At the end of day 6, persons 1, 3, and 4 know the secret.

### Constraints:
- `1 <= n <= 1000`
- `1 <= delay < forget <= days <= 1000`
