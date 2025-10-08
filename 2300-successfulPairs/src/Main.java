import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        int[] spells = {3,1,2};
        int[] portions = {8,5,8};
        int success = 16;

        System.out.println("The successful pairs are: " + Arrays.toString(successfulPairs(spells, portions, success)));

    }

    public static int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions); // ascending order
        int n = spells.length;
        int m = potions.length;
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            int left = 0, right = m;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if ((long) spells[i] * potions[mid] >= success) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            result[i] = m - left; // all potions from left to end are successful
        }

        return result;
    }

    public static int[] successfulPairsBrute(int[] spells, int[] potions, long success) {
        int size = spells.length;
        int[] result = new int[size];

        // Sort in ascending order first
        Arrays.sort(potions);

        // Ordering potions in descending order
        int n = potions.length;
        for (int i = 0; i < n / 2; i++) {
            int temp = potions[i];
            potions[i] = potions[n - 1 - i];
            potions[n - 1 - i] = temp;
        }

        for (int i=0; i<size; i++) {
            int counter = 0;
            for(int j=0; j<potions.length;j++) {
                long number = (long) spells[i] * potions[j];
                if(number >= success) {
                    counter++;
                }
                else {
                    break;
                }
            }
            result[i] = counter;
        }
        return result;
    }
}