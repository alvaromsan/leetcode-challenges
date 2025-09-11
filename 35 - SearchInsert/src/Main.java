import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("Welcome! (type 'exit' to quit)");
            System.out.print("Insert the sorted nums list: ");
            String line1 = input.nextLine();

            if (line1.equalsIgnoreCase("exit")) {
                System.out.println("Exiting program. Goodbye!");
                break;
            }

            int[] nums = Arrays.stream(line1.split(" ")).mapToInt(Integer::parseInt).toArray();

            System.out.print("Insert the target number: ");
            String line2 = input.nextLine();

            int target = Integer.parseInt(line2.split(" ")[0]);

            int index = searchInsert(nums, target);

            System.out.println("nums = " + Arrays.toString(nums) + ", target = " + target);
            System.out.println("Index is: " + index);

            System.out.println("------");
        }

        input.close();
    }

    // Given a sorted array of distinct integers and a target value,
    // return the index if the target is found.
    // If not, return the index where it would be if it were inserted in order.
    public static int searchInsert(int[] nums, int target) {
        for(int i=0; i<nums.length; i++) {
            if(nums[i] > target || nums[i] == target) {
                return i;
            }
        }
        return nums.length; // The number is not found and is not in between any value -> Must be at the end
    }
}