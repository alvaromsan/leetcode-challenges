import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        int[][] classes = {{2,4},{3,9},{4,5},{2,10}};
        int extraStudents = 4;

        double result = maxAverageRatio(classes,extraStudents);

        System.out.println("The maximum possible average pass ratio after assigning the extraStudents is: " + result);

    }

    public static double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<double[]> pq = new PriorityQueue<>(
                (a, b) -> Double.compare(b[0], a[0]) // max-heap comparing "gain"
        );

        double totalRatio = 0.0;
        int n = classes.length;

        for (int[] iClass: classes) {
            // [gain % if adding new student, pass ratio, passed students, total students]
            double p = iClass[0];
            double t = iClass[1];
            totalRatio += p/t;
            double gain = (p + 1.0) / (t + 1.0) - p / t;
            double[] iClass_values = {gain, iClass[0], iClass[1]};
            pq.add(iClass_values);
        }

        for(int i=0; i<extraStudents;i++){
            // Obtain the row where the gain is MAX (the first one)
            double[] maxGainRow = pq.poll();
            // Calculate new gain. Since we are going to use this row, we need to calculate the next gain with added student
            double p = maxGainRow[1] + 1;
            double t = maxGainRow[2] + 1;
            double newGain = (p + 1.0) / (t + 1.0) - p / t;

            // Add the extra ratio from adding the student
            totalRatio += maxGainRow[0];

            double[] newRow = {newGain, maxGainRow[1]+1, maxGainRow[2]+1};
            pq.add(newRow);
        }

        return totalRatio / n;
    }
}