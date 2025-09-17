
// Brute force - method. Encounters a Time Limit Exceeded eventually
public class FoodRatingsB {

    private String[] foods;
    private String[] cuisines;
    private int[] ratings;

    public FoodRatingsB(String[] foods, String[] cuisines, int[] ratings) {
        this.foods = foods;
        this.cuisines = cuisines;
        this.ratings = ratings;
    }

    public void changeRating(String food, int newRating) {
        for(int i=0;i<foods.length;i++) {
            if(food.equals(foods[i])) {
                ratings[i] = newRating;
                break;
            }
        }
    }

    public String highestRated(String cuisine) {
        int highestRating = 0;
        String highestRatedFood = "";

        for(int i=0; i<cuisines.length;i++) {
            if (cuisine.equals(cuisines[i]) && ratings[i]>= highestRating) {
                if(highestRating == 0) {
                    highestRatedFood = foods[i];
                    highestRating = ratings[i];
                } else if ((ratings[i] == highestRating) && (foods[i].compareTo(highestRatedFood) < 0)) {
                    highestRatedFood = foods[i];
                    highestRating = ratings[i];
                } else if (ratings[i] > highestRating) {
                    highestRatedFood = foods[i];
                    highestRating = ratings[i];
                }
            }
        }
        return highestRatedFood;
    }
}
