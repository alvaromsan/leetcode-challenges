package org.maven;

import java.util.Arrays;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        int[] nums = {1,2,2};

        int result = minIncrementForUnique(nums);

        System.out.println("The minimum increment to make the array unique is: " + result);

    }

    // Time Limit Exceeded
    public static int minIncrementForUniqueW(int[] nums) {

        // Map that contains number - occurrences of the number
        HashMap<Integer,Integer> map = new HashMap<>();
        int size = nums.length;
        int increments = 0;

        for(int i=0; i < size; i++) {
            int initialValue = nums[i];

            //
            if (map.containsKey(initialValue)) {
                int occurrences = map.get(initialValue);
                int newValue = initialValue;

                // Increment the newValue until it is unique in our map
                while(map.containsKey(newValue)) {
                    newValue++;
                }
                map.put(newValue,1); // Add the new value to the map
                increments += newValue - initialValue;
            }
            // If the number hasn't appeared yet, add the initialValue to the map
            else {
                map.put(initialValue,1);
            }
        }
        return increments;
    }

    public static int minIncrementForUnique(int[] nums) {
        int size = nums.length;
        Arrays.sort(nums);
        int increments = 0;

        for (int i=1; i < size; i++) {
            int initialValue = nums[i];

            if(initialValue <= nums[i-1]) {
                int newValue = nums[i-1] + 1;
                increments += newValue - initialValue;
                nums[i] = newValue;
            }
        }
        return increments;
    }
}