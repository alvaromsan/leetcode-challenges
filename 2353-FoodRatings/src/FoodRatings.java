import java.util.*;

// Using Maps instead
public class FoodRatings {

    static class Food {
        String name;
        String cuisine;
        int rating;

        Food(String name, String cuisine, int rating) {
            this.name = name;
            this.cuisine = cuisine;
            this.rating = rating;
        }
    }

    private Map<String, Food> foodMap = new HashMap<>();
    private Map<String, TreeSet<Food>> cuisineToFoods = new HashMap<>();

    private Comparator<Food> comp = (a, b) -> {
        if (b.rating != a.rating) return b.rating - a.rating; // higher rating first
        return a.name.compareTo(b.name); // lexicographically smaller first
    };

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        for (int i = 0; i < foods.length; i++) {
            Food f = new Food(foods[i], cuisines[i], ratings[i]);
            foodMap.put(foods[i], f);

            cuisineToFoods.putIfAbsent(cuisines[i], new TreeSet<>(comp));
            cuisineToFoods.get(cuisines[i]).add(f);
        }
    }

    public void changeRating(String foodName, int newRating) {
        Food f = foodMap.get(foodName);
        TreeSet<Food> set = cuisineToFoods.get(f.cuisine);

        set.remove(f);
        f.rating = newRating;
        set.add(f);
    }

    public String highestRated(String cuisine) {
        return cuisineToFoods.get(cuisine).first().name;
    }
}

