package org.maven;

/*
Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once.
The relative order of the elements should be kept the same. Then return the number of unique elements in nums.

Consider the number of unique elements of nums to be k, to get accepted, you need to do the following things:

Change the array nums such that the first k elements of nums contain the unique elements in the order they were present in nums initially.
The remaining elements of nums are not important as well as the size of nums.
Return k.
*/

public class Main {
    public static void main(String[] args) {
        int[] nums = {1,1,2};

        System.out.println("The total unique numbers is: " + removeDuplicates(nums));
    }

    public static int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;

        int current_value = nums[0];
        int j = 1;

        for(int i=1; i<n;i++){
            if(current_value != nums[i]){
                current_value=nums[i];
                nums[j]=current_value;
                j++;
            }
        }
        return j;
    }
}