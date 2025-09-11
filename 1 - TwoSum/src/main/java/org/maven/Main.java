package org.maven;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
        // You may assume that each input would have exactly one solution, and you may not use the same element twice.

        int [] nums = {0,4,3,0}; // array of numbers we will consider to sum
        int target = 0; // result of the sum we want to achieve

        int [] result = twoSumMap(nums, target);

        System.out.println(Arrays.toString(result));
    }

    public static int[] twoSum(int[] nums, int target) {

        int size = nums.length;

        for (int i = 0; i < size; i++) {
            for (int j = i+1; j < size; j++) {
                if ( (nums[i] + nums[j]) == target) {
                    return new int[]{i, j}; // solution found
                }
            }
        }
        return new int[]{}; // solution not found
    }

    public static int[] twoSumFaster(int[] nums, int target) {

        int size = nums.length;

        // In this case, as we know the solution is unique, it is more likely that the solution is found in the start,
        // so we can instead to the checking from start <-- middle (and increase the index in case the solution is not found


        for (int i = 1; i < size; i++) { // Start in the first index
            for (int j = i; j < size; j++) { // And check the numbers right to left
                if ( (nums[j] + nums[j-i]) == target) { // And see if they add the target together
                    return new int[]{j, j-i}; // solution found
                }
            }
        }
        return new int[]{}; // solution not found
    }

    public static int[] twoSumMap(int[] nums, int target) {

        int size = nums.length;
        Map<Integer, Integer> map = new HashMap<>(); // Faster than a double loop

        for (int i = 0; i < size; i++) {
            int current_value = nums[i];
            int complement = target - current_value;

            if(map.containsKey(complement)) {
                return new int[] {map.get(complement), i};
            }

            map.put(i, current_value);

        }
        return new int[]{}; // solution not found
    }
}