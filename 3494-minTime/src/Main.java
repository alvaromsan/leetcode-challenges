public class Main {
    public static void main(String[] args) {
        int[] skill = {1,5,2,4};
        int[] mana  = {5,1,4,2};

        System.out.println("The minimum time to complete all brewing is: " + minTime(skill,mana));
    }

    public static long minTime(int[] skill, int[] mana) {
        int n = skill.length;
        int m = mana.length;
        long[] dp = new long[n]; // finish times of previous potion

        // First potion
        dp[0] = (long) skill[0] * mana[0];
        for (int i = 1; i < n; i++) {
            dp[i] = dp[i - 1] + (long) skill[i] * mana[0];
        }

        // Process remaining potions
        for (int j = 1; j < m; j++) {
            long cte = dp[0];
            long prevFinish = 0; // cumulative handoff for current potion

            for (int i = 0; i < n; i++) {
                prevFinish += (long) skill[i] * mana[j]; // handoff from previous wizard
                long requiredStart = dp[i] - (prevFinish - (long) skill[i] * mana[j]);
                if (requiredStart > cte) cte = requiredStart;
            }

            prevFinish = 0;
            for (int i = 0; i < n; i++) {
                prevFinish += (long) skill[i] * mana[j];
                dp[i] = cte + prevFinish;
            }
        }

        return dp[n - 1]; // last wizard finishes last potion
    }
}