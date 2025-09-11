import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("Welcome (type 'exit' to quit) ");
            System.out.print("Please insert the list of numbers (separated by spaces): ");
            String line = input.nextLine();

            if (line.equalsIgnoreCase("exit")) {
                System.out.println("Exiting program. Goodbye!");
                break;
            }

            int[] nums = Arrays.stream(line.trim().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            System.out.print("Please insert the number to eliminate from the list: ");
            int val = Integer.parseInt(input.nextLine());

            int result = removeElement(nums, val);

            System.out.println("nums is: " + Arrays.toString(nums)); // Updated nums without "val"
            System.out.println("val is: " + val);

            // The number of elements in nums which are not equal to val
            System.out.println("k is: " + result); //
            System.out.println("-----");
        }

        input.close();
    }

    // Remove all elements in nums that are "val"
    public static int removeElement(int[] nums, int val) {
        int k = 0; // number of times the nums[i] is != val
        for (int num : nums) {
            if (num != val) {
                nums[k] = num; // Update the same array directly
                k++;
            }
        }
        return k;
    }
}