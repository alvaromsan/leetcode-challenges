package org.maven;

public class Main {
    public static void main(String[] args) {
        int x = 121;

        System.out.println("Is the number '" + x + "' a palindrome number?" + "\n" + (isPalindromeInt(x) ? "Yes" : "No"));

    }

    public static boolean isPalindromeString(int x) {

        if (x < 0) return false; // negative number cannot be palindrome

        String number = String.valueOf(x);
        int length = number.length();
        int halfLength = (length % 2 == 0) ? (length / 2) : (length / 2 + 1); // even number : odd number

        String firstHalf = number.substring(0, length / 2);
        String secondHalf = number.substring(halfLength, length);
        String secondHalfReversed = new StringBuilder(secondHalf).reverse().toString();

        return firstHalf.equals(secondHalfReversed);
    }

    // We will take each number by dividing between 10, 100, 1000, 10000, etc
    // == diving between 10 and removing the digit added
    public static boolean isPalindromeInt(int x) {
        if (x < 0) return false; // negative number cannot be palindrome

        int original  = x;
        int reversed = 0;

        while (x>0) {
            int digit = x%10; // "decimal part" which is the digit we want
            reversed = reversed*10 + digit;
            x = x/10; // remove the digit added for next interaction
        }
        return original == reversed;
    }
}