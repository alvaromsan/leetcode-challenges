public class Main {
    public static void main(String[] args) {
        int x = 2;
        int y = 7;
        int z = 4;

        int winner = findClosest(x,y,z);
        System.out.println("The winner is the person: " + winner);
    }

    /*
    Given three integers x, y, and z, representing the positions of three people on a number line:
        - x is the position of Person 1.
        - y is the position of Person 2.
        - z is the position of Person 3, who does not move.
    Both Person 1 and Person 2 move toward Person 3 at the same speed.

    Determine which person reaches Person 3 first:
        - Return 1 if Person 1 arrives first.
        - Return 2 if Person 2 arrives first.
        - Return 0 if both arrive at the same time.
    Return the result accordingly.
     */
    public static int findClosest(int x, int y, int z) {
        int distance_xz = Math.abs(x-z);
        int distance_yz = Math.abs(y-z);

        if (distance_yz == distance_xz) return 0;

        return (distance_yz > distance_xz) ? 1:2;
    }
}