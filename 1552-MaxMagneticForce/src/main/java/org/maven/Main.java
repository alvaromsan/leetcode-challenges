package org.maven;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        int[] position = {79,74,57,22}; // available baskets
        int m = 4; // number of balls we want to put in the baskets

        System.out.println("The min MaxMagForce between the balls will be: " + maxDistance(position,m));

    }

    // Supposing that only 2 balls have the minimum distance and the others are put in whatever baskets
    public static int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int n = position.length;
        int last_value = position[n-1];
        int first_value = position[0];


        if (m==2){
            return last_value-first_value;
        }
        if (m==n) {
            int result = position[1] - position[0];
            for(int i=2; i<position.length; i++) {
                int currentMagForce = position[i] - position[i-1];
                if(currentMagForce < result) { // The smallest magForce is our result
                    result = currentMagForce;
                }
            }
            return result;
        }
        else { // 2 < m < n
            // Need a counter to track how many balls are "located" - check there are enough "spaces" to locate
            // the remaining balls after having located one ball

            // Need a variable to track what the next number needs to look like
            // (previous located ball + max_force on that iteration)

            // search range for F
            int low = 1;
            int high = (position[n - 1] - position[0]) / (m - 1);
            int answer = 0;

            // mid is always the middle of the current [low, high] range.
            //Each check cuts the search space in half:
            // - If feasible → shift low upward.
            // - If not → shift high downward.
            //Stops when range collapses (low > high).
            //Final answer = the largest feasible mid we saw.
            while (low <= high) {
                int mid = low + (high - low) / 2; // candidate force
                if (canPlace(position, m, mid)) {
                    answer = mid;     // feasible → save and try bigger
                    low = mid + 1;
                } else {
                    high = mid - 1;   // not feasible → try smaller
                }
            }
            return answer;
        }
    }

    // greedy feasibility check
    private static boolean canPlace(int[] position, int m, int force) {
        int count = 1;  // first ball at position[0]
        int lastPos = position[0];

        for (int i = 1; i < position.length; i++) {
            if (position[i] - lastPos >= force) {
                count++;
                lastPos = position[i];
                if (count >= m) return true; // all balls placed
            }
        }
        return false; // not enough balls placed
    }
}