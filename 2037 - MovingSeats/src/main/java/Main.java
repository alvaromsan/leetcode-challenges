import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        int[] seats = {3,1,5};
        int[] students = {2,7,4};


        int result = minMovesToSeat(seats, students);

        System.out.println("The required moves are: " + result);

    }

    /* EXPLANATION
    **  Input: seats = [3,1,5], students = [2,7,4]
    **  Output: 4
    **  Explanation: The students are moved as follows:
    **  - The first student is moved from from position 2 to position 1 using 1 move.
    **  - The second student is moved from from position 7 to position 5 using 2 moves.
    **  - The third student is moved from from position 4 to position 3 using 1 move.
    **  In total, 1 + 2 + 1 = 4 moves were used.
    */
    public static int minMovesToSeat(int[] seats, int[] students) {

        Arrays.sort(seats);
        Arrays.sort(students);

        int size = seats.length;
        int moves = 0;

        for (int i=0; i< size; i++) {
            int number_moves_i = seats[i] - students[i];
            moves += Math.abs(number_moves_i);
        }

        return moves;
    }
}
