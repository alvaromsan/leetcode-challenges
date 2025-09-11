import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[][] points = {{0,2},{3,1},{6,0},{1,5}};

        int numberOfPairs = brute_force_numberOfPairs(points);

        System.out.println("The number of pairs that meet the conditions is: " + numberOfPairs);
    }

    // 3 loops checking the points one by one 3 times:
    // 1) Check all the points (a)
    // 2) Check all possible connections with those points - that meet upper-left conditions (b)
    // 3) Check if there is any points inside the a-b created rectangle (c)
    // Complexity: O(n³) - better for small "n" - points_size
    public static int brute_force_numberOfPairs(int[][] points) {
        int n = points.length;
        int count = 0;

        // a = point we study
        for (int i = 0; i < n; i++) {
            int a_x = points[i][0], a_y = points[i][1];

            // b = candidate to connect with a (can point "a" be a potential "upper-left" point for "b"?)
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                int b_x = points[j][0], b_y = points[j][1];

                // condition: a must be upper-left of b (rectangle or line)
                if ((a_x<b_x && a_y>=b_y) || (a_x<=b_x && a_y>b_y)) {
                    boolean empty = true;

                    // c = potential collider
                    for (int k = 0; k < n; k++) {
                        if (k == i || k == j) continue;
                        int c_x = points[k][0], c_y = points[k][1];

                        // check if there is a point "c" that lies inside/on rectangle a-b
                        if (a_x <= c_x && c_x <= b_x &&
                                b_y <= c_y && c_y <= a_y) {
                            empty = false;
                            break;
                        }
                    }
                    if (empty) count++;
                }
            }
        }
        return count;
    }


    // Prefix-sum approach:
    // 1) Create a "matrix" that tells you how many points are inside a rectangle --> by giving corner cords.
    // 2) We will iterate through all the points (a) and all possible connections with that point (b) and check
    // if there are any points inside that rectangle --> If there aren't, then the pair is valid.
    // Complexity: O(n² + grid size)
    public static int mapping_countPairs(int[][] points) {
        // Step 1: find bounds to create grid
        int maxX = 0, maxY = 0;
        for (int[] p : points) {
            maxX = Math.max(maxX, p[0]);
            maxY = Math.max(maxY, p[1]);
        }

        // Step 2: create grid and mark points (offset by +1)
        int[][] grid = new int[maxY + 3][maxX + 3]; // [y][x]
        for (int[] p : points) {
            grid[p[1] + 1][p[0] + 1] = 1;
        }

        // Step 3: build 2D prefix sum
        int[][] psum = new int[maxY + 3][maxX + 3];
        for (int y = 1; y <= maxY + 2; y++) {
            for (int x = 1; x <= maxX + 2; x++) {
                psum[y][x] = grid[y][x] + psum[y-1][x] + psum[y][x-1] - psum[y-1][x-1];
            }
        }

        int count = 0;

        // Step 4: iterate all pairs (A,B)
        for (int i = 0; i < points.length; i++) {
            int a_x = points[i][0];
            int a_y = points[i][1];
            for (int j = 0; j < points.length; j++) {
                if (i == j) continue; // skip same point
                int b_x = points[j][0];
                int b_y = points[j][1];

                // Check A is upper-left of B (allow line)
                if ((a_x <= b_x && a_y >= b_y) && (a_x < b_x || a_y > b_y)) {

                    // rectangle bounds (offset by +1)
                    int left = Math.min(a_x, b_x) + 1;
                    int right = Math.max(a_x, b_x) + 1;
                    int bottom = Math.min(a_y, b_y) + 1;
                    int top = Math.max(a_y, b_y) + 1;

                    // query points inside rectangle
                    int total = psum[top][right] - psum[bottom-1][right] - psum[top][left-1] + psum[bottom-1][left-1];

                    // exclude corners A and B
                    total -= 1; // remove A
                    total -= 1; // remove B if different from A

                    if (total == 0) {
                        count++;
                    }
                }
            }
        }

        return count;

    }
}