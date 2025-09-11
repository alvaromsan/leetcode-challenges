package org.maven;

import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // arr1 is longer than arr2
        // Each arr2[i] is in arr1 but not sorted

        int index = 0; // value of the index for the result array that will be completing
        int[] arr1 = {2,3,1,3,2,4,6,7,9,2,19,16,18,13};
        int[] arr2 = {2,1,4,3,9,6};

        for (int i=0; i<arr2.length; i++) {
            // i == value that we want to study
            for (int j=0; j<arr1.length; j++) {
                if (arr1[j] == arr2[i]) {
                    int temp = arr1[index]; // value we want to replace at the "start" of the string
                    arr1[index] = arr1[j];
                    arr1[j] = temp;
                    index++;
                }
            }
        }

        for (int x = index; x < arr1.length; x++) {
            for (int k = index; k < arr1.length- 1; k++) {
                if (arr1[k] > arr1[k + 1]) {
                    int tmp = arr1[k + 1];
                    arr1[k + 1] = arr1[k];
                    arr1[k] = tmp;
                }
            }
        }
        System.out.println(Arrays.toString(arr1));
    }
}