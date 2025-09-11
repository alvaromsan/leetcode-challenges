package org.maven;

/*
There is a bookstore owner that has a store open for n minutes. Every minute, some number of customers enter the store.
You are given an integer array customers of length n where customers[i] is the number of the customer that enters the
store at the start of the ith minute and all those customers leave after the end of that minute.

On some minutes, the bookstore owner is grumpy. You are given a binary array grumpy where grumpy[i] is 1 if the bookstore
owner is grumpy during the ith minute, and is 0 otherwise.

When the bookstore owner is grumpy, the customers of that minute are not satisfied, otherwise, they are satisfied.

The bookstore owner knows a secret technique to keep themselves not grumpy for minutes consecutive minutes, but can only use it once.

Return the maximum number of customers that can be satisfied throughout the day.
*/
public class Main {
    public static void main(String[] args) {
        int[] customers = {3,2,5};
        int[] grumpy = {0,1,1};
        int minutes = 2;

        System.out.println("The maximum number of customers that can be satisfied is: " + maxSatisfied(customers,grumpy,minutes));
    }

    public static int maxSatisfied(int[] customers, int[] grumpy, int minutes) {

        int increment = 0;
        int total_c = 0;
        int total_g = 0;

        int total = 0;
        int size = customers.length;

        for(int i=0; i < size; i++){
            total += grumpy[i]==0? customers[i]:0;
            if (i == 0) {
                // Calculate the first minutes increments
                for (int j = 0; j < minutes; j++) {
                    total_c += grumpy[j] == 0 ? customers[j] : 0;
                    total_g += customers[j];
                }
                increment = total_g - total_c;
                // Subtract the current value
                total_c -= grumpy[i] == 0 ?customers[i]:0;
                total_g -= customers[i];
            } else if (i+minutes <= size) {
                // To then add the i+minutes values
                total_c += grumpy[i+minutes-1] == 0 ? customers[i+minutes-1] : 0;
                total_g += customers[i+minutes-1];
                // And check if the different is higher or not
                increment = Math.max(total_g-total_c, increment);
                // Subtract the current value
                total_c -= grumpy[i] == 0 ? customers[i] : 0;
                total_g -= customers[i];
            }
        }
        return total+increment;
    }
}