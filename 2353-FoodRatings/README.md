# 2353. Design a Food Rating System

https://leetcode.com/problems/design-a-food-rating-system/description/

## Problem Description

Implement a food rating system that:
- Stores foods, their cuisines, and ratings.
- Allows updating the rating of a food.
- Retrieves the highest-rated food for a given cuisine.
    - If multiple foods share the same rating, return the lexicographically smallest one.

---

## Operations

- `FoodRatingsB(foods, cuisines, ratings)`
- `changeRating(food, newRating)`
- `highestRated(cuisine)`

---

## Example

```text
Input:
["FoodRatingsB", "highestRated", "changeRating", "highestRated"]
[[["kimchi","miso"], ["korean","japanese"], [9, 12]], ["korean"], ["kimchi", 15], ["korean"]]

Output:
[null, "kimchi", null, "kimchi"]
```

---

## Constraints

- Each food belongs to exactly one cuisine.
- Ratings are integers.
- Names are strings.
