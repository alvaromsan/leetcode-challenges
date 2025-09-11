public class Main {
    public static void main(String[] args) {

        int n = 15; // Max flowers in row 1
        int m = 15; // Max flowers in row 2

        long possible_pairs = flowerGame(n,m);

        System.out.println("Return the number of possible pairs (x, y) that satisfy the conditions is: " + possible_pairs);
    }


    // Alice takes the first turn.
    // In each turn, a player must choose either one of the lane and pick one flower from that side.
    // At the end of the turn, if there are no flowers left at all,
    // the current player captures their opponent and wins the game.
    // Notes:
    // 1) Alice must win the game according to the described rules.
    // 2) The number of flowers x in the first lane must be in the range [1,n].
    // 3) The number of flowers y in the second lane must be in the range [1,m].

    // Return: the number of possibilities where Alice WINS
    // Solution: x+y = ODD number for Alice to be LAST picking in the last turn since she's starting
    public static long flowerGame(int n, int m) {
        // Brute-force way
        /*
        int counter = 0;
        for(int x=1; x <= n; x++){
            for(int y=1; y <= m;y++) {
                int x_y = x+y;
                if (x_y % 2 == 1) {//number is odd
                    counter++;
                }
            }
        }
         */
        return (long) n *m/2;
    }
}