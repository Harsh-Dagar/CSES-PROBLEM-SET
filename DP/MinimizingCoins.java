package DP;

import java.util.Arrays;
import java.util.Scanner;

public class MinimizingCoins {

    private static final int INF = 1_000_000_000;

    private static int findMinCoins(int[] coins, int target) {
        int[] dp = new int[target + 1];
        Arrays.fill(dp, INF);

        dp[0] = 0;

        for (int sum = 1; sum <= target; sum++) {
            for (int coin : coins) {
                if (sum >= coin) {
                    dp[sum] = Math.min(dp[sum], dp[sum - coin] + 1);
                }
            }
        }

        return dp[target] == INF ? -1 : dp[target];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int x = sc.nextInt();

        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }

        System.out.println(findMinCoins(coins, x));
        sc.close();
    }
}