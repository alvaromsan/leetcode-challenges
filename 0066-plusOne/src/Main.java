import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] digits = {9,9,9,9,9,9,9,9,9};

        int[] digits_plus_one = plusOne(digits);

        System.out.println("The value+1 is: " + Arrays.toString(digits_plus_one));

    }

    public static int[] plusOne(int[] digits) {
        int carry = 0;
        int size = digits.length-1;

        for(int i=size;i>=0;i--) {
            int current_value = digits[i];

            // We are adding +1 if we're starting or we have a carry from previous iteration
            if(carry == 1 || i==size) current_value++;

            if(current_value == 10) {
                carry = 1;
                digits[i] = 0;
            }
            else {
                digits[i] = current_value;
                return digits;
            }
        }

        // If we are here is because carry = 1, which means we need to extend our array with a front "1"
        int[] newArray = new int[digits.length + 1];
        newArray[0] = 1;

        // Copy the original array into newArray starting at index 1
        System.arraycopy(digits, 0, newArray, 1, digits.length);
        return newArray;
    }
}