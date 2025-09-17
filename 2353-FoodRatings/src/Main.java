public class Main {
    public static void main(String[] args) {
        // Step 1: Initialize the FoodRatings object
        String[] foods = {"kimchi","miso","sushi","moussaka","ramen","bulgogi"};
        String[] cuisines = {"korean","japanese","japanese","greek","japanese","korean"};
        int[] ratings = {9,12,8,15,14,7};

        FoodRatingsB foodRatings = new FoodRatingsB(foods, cuisines, ratings);

        // Step 2: Perform operations and print outputs
        System.out.println(foodRatings.highestRated("korean"));   // Expected: "kimchi"
        System.out.println(foodRatings.highestRated("japanese")); // Expected: "ramen"

        foodRatings.changeRating("sushi", 16);
        System.out.println(foodRatings.highestRated("japanese")); // Expected: "sushi"

        foodRatings.changeRating("ramen", 16);
        System.out.println(foodRatings.highestRated("japanese")); // Expected: "ramen" (lexicographically smaller among highest)
    }
}