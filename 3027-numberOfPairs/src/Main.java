import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[][] points = {{0,2},{3,1},{6,0},{1,5}};

        int numberOfPairs = negative_numberOfPairs(points);

        System.out.println("The number of pairs that meet the conditions is: " + numberOfPairs);
    }

    // Steps:
    // 1) Ordering the points from lowest to highest (TreeSet does this by default)
    // 2) Compressing the original values into a "compressed" one which is called xMap,yMap
    // Here, we are adding "compressed values" (linear, 1-N) to all our values inside "points"   v
    // 3) Evaluating where in the "grid" the points exists --> build grid
    // 4) Evaluating how many points are inside a potential rectangle
    // 5) Checking all potential a-b points - making the conversions to the "compressed" values
    // and checking how many points are within a-b --> If 0, then count++
    public static int negative_numberOfPairs(int[][] points) {
        int n = points.length;

        // Step 1: collect unique x and y coordinates
        TreeSet<Integer> xSet = new TreeSet<>();
        TreeSet<Integer> ySet = new TreeSet<>();
        for (int[] p : points) {
            xSet.add(p[0]);
            ySet.add(p[1]);
        }

        // Step 2: coordinate compression
        Map<Integer, Integer> xMap = new HashMap<>();
        Map<Integer, Integer> yMap = new HashMap<>();
        int idx = 1;
        for (int x : xSet) xMap.put(x, idx++);
        idx = 1;
        for (int y : ySet) yMap.put(y, idx++);

        int maxX = xMap.size() + 2;
        int maxY = yMap.size() + 2;

        // Step 3: build grid
        int[][] grid = new int[maxY][maxX]; // [y][x]
        for (int[] p : points) {
            int x = xMap.get(p[0]);
            int y = yMap.get(p[1]);
            grid[y][x] = 1;
        }

        // Step 4: prefix sum
        int[][] psum = new int[maxY][maxX];
        for (int y = 1; y < maxY; y++) {
            for (int x = 1; x < maxX; x++) {
                psum[y][x] = grid[y][x] + psum[y-1][x] + psum[y][x-1] - psum[y-1][x-1];
            }
        }

        int count = 0;

        // Step 5: iterate all pairs (A,B)
        for (int i = 0; i < n; i++) {
            int a_x = xMap.get(points[i][0]);
            int a_y = yMap.get(points[i][1]);
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                int b_x = xMap.get(points[j][0]);
                int b_y = yMap.get(points[j][1]);

                // Upper-left condition: A is upper-left of B
                if ((a_x <= b_x && a_y >= b_y) && (a_x < b_x || a_y > b_y)) {
                    int left = Math.min(a_x, b_x); //a_x
                    int right = Math.max(a_x, b_x); // b_x
                    int bottom = Math.min(a_y, b_y); // b_y
                    int top = Math.max(a_y, b_y); // a_y

                    int total = psum[top][right] - psum[bottom-1][right] - psum[top][left-1] + psum[bottom-1][left-1];
                    total -= 2; // exclude A and B

                    if (total == 0) count++;
                }
            }
        }
        return count;
    }
}