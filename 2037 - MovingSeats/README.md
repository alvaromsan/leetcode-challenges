# 2037. Minimum Number of Moves to Seat Everyone

https://leetcode.com/problems/minimum-number-of-moves-to-seat-everyone/description/

## Problem Description

There are `n` seats and `n` students in a classroom. The students are currently seated in some order, and you are given an integer array `seats` representing the positions of the students. You are also given an integer array `students` representing the positions of the students in their original seating arrangement.

Your task is to determine the minimum number of moves required to move each student to a seat such that no two students are in the same seat. Note that there may be multiple seats available at the beginning, but each student must be seated in exactly one seat.

### Example 1:
**Input:**  
`seats = [3, 1, 5, 2], students = [2, 4, 1, 3]`

**Output:**  
`4`

**Explanation:**
- Move student 1 from position 2 to position 1.
- Move student 2 from position 4 to position 2.
- Move student 3 from position 1 to position 3.
- Move student 4 from position 3 to position 4.

### Example 2:
**Input:**  
`seats = [4, 1, 5, 9, 3], students = [1, 3, 2, 6, 4]`

**Output:**  
`10`

**Explanation:**
- Move student 1 from position 1 to position 1.
- Move student 2 from position 3 to position 3.
- Move student 3 from position 2 to position 5.
- Move student 4 from position 6 to position 9.
- Move student 5 from position 4 to position 4.

### Constraints:
- `n == seats.length == students.length`
- `1 <= n <= 100`
- `1 <= seats[i], students[i] <= 100`
- All values in `seats` and `students` are distinct.
