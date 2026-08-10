package DP;

import java.util.*;

public class ArrayDescription {

    static final int MOD = 1_000_000_007;

    static long findWays(int[] arr, int m) {
        int n = arr.length;

        long[] dp = new long[m + 2];

        // Initialize first position
        if (arr[0] == 0) {
            Arrays.fill(dp, 1, m + 1, 1);
        } else {
            dp[arr[0]] = 1;
        }

        for (int i = 1; i < n; i++) {

            long[] next = new long[m + 2];

            if (arr[i] == 0) {
                for (int value = 1; value <= m; value++) {
                    next[value] = (dp[value - 1]
                            + dp[value]
                            + dp[value + 1]) % MOD;
                }
            } else {
                int value = arr[i];

                next[value] = (dp[value - 1]
                        + dp[value]
                        + dp[value + 1]) % MOD;
            }

            dp = next;
        }

        // Sum all possible ending values
        if (arr[n - 1] == 0) {
            long answer = 0;

            for (int value = 1; value <= m; value++) {
                answer = (answer + dp[value]) % MOD;
            }

            return answer;
        }

        return dp[arr[n - 1]];
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            int[] arr = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            System.out.println(findWays(arr, m));
        }
    }
}