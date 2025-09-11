import java.util.ArrayList;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        int n = 6;
        int delay = 2;
        int forget = 4;

        int peopleAwareOfSecret = peopleAwareOfSecret(n,delay,forget);

        System.out.println("The number of people aware of the secret on day '"+n+"' is: " + peopleAwareOfSecret);
    }

    public static int peopleAwareOfSecret(int n, int delay, int forget) {
        final int MOD = 1_000_000_007;

        long[] dp = new long[n + 1];  // dp[i] = number of people who learn on day i
        dp[1] = 1; // Day 1: first person learns the secret

        long active = 0; // number of people eligible to share today
        long result = 0; // total people who still remember the secret on day n

        for (int day = 2; day <= n; day++) {

            // 1️⃣ Add new sharers: people who learned 'delay' days ago can start sharing
            if (day - delay >= 1) {
                active = (active + dp[day - delay]) % MOD;
            }

            // 2️⃣ Remove forgotten people: those who learned 'forget' days ago
            //    They forget before sharing today
            if (day - forget >= 1) {
                active = (active - dp[day - forget] + MOD) % MOD;
                // +MOD ensures no negative numbers after subtraction
            }

            // 3️⃣ People who learn today = active sharers
            dp[day] = active;
        }

        // 4️⃣ Sum all people who still remember the secret at day n
        //    This includes anyone who learned in the last 'forget' days
        for (int day = Math.max(1, n - forget + 1); day <= n; day++) {
            result = (result + dp[day]) % MOD;
        }

        return (int) result;
    }
}