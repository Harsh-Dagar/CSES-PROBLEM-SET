package DP;

import java.util.*;

public class CoinCombinationsII {

    static final int MOD = 1_000_000_007;

    static long calculateNumberOfOrderedWays(int sum, int arr[]) {

        long dp[] = new long[sum + 1];

        Arrays.fill(dp, 0);
        dp[0] = 1;

        for (int idx = 0; idx < arr.length; idx++) {
            for (int currSum = 1; currSum <= sum; currSum++) {
                long ways = dp[currSum];
                if (currSum - arr[idx] >= 0) {
                    ways = (ways + dp[currSum - arr[idx]]) % MOD;
                }
                dp[currSum] = ways % MOD;
            }
        }

        return dp[sum];
    }

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            int sum = sc.nextInt();
            int arr[] = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            long res = calculateNumberOfOrderedWays(sum, arr);
            System.out.println(res);

        }

    }
}