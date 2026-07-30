package DP;

import java.util.*;

public class CoinCombinationsI {

    static final int MOD = 1_000_000_007;

    static long calculateNumberOfWays(int sum, int arr[]) {

        long dp[] = new long[sum + 1];
        Arrays.fill(dp, 0);

        dp[0] = 1;

        for (int currSum = 1; currSum <= sum; currSum++) {
            long ways = 0;
            for (int idx = 0; idx < arr.length; idx++) {

                if (arr[idx] <= currSum) {
                    ways = (ways + dp[currSum - arr[idx]])%MOD;
                }
            }
            dp[currSum] = ways%MOD;
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

            long res = calculateNumberOfWays(sum, arr);
            System.out.println(res);

        }

    }
}