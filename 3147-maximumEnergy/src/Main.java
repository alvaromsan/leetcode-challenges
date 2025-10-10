public class Main {
    public static void main(String[] args) {
        int[] energy = {5,2,-10,-5,1};
        int k = 3;

        System.out.println("The maximum energy we can absorb is: " + maximumEnergy(energy,k));
    }

    public static int maximumEnergy(int[] energy, int k) {
        int n = energy.length;
        // dp is the accumulated energy (accounting the k jumps)
        // from energy[n-1] to the current dp position (i)
        int[] dp = new int[n];
        int maxEnergy = Integer.MIN_VALUE;

        for (int i=n-1;i>=0;i--) {
            dp[i] = energy[i] + ((i+k >= n)? 0:dp[i+k]);
            if(dp[i] > maxEnergy) maxEnergy=dp[i];
        }
        return maxEnergy;
    }
}