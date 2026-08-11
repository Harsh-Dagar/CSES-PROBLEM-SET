package DP;

import java.util.*;

public class CountingTowers {

    static final int MOD = (int) 1e9 + 7;
    static long dp[][];

    static void populateDP(int n) {
        dp[1][0] = 1;
        dp[1][1] = 1;
        // 0->split
        // 1->not split
        for (int i = 2; i <= n; i++) {
            // non split case
            dp[i][1] = ((2 * dp[i - 1][1]) + (dp[i - 1][0])) % MOD;
            // split case
            dp[i][0] = ((dp[i - 1][1]) + (4 * dp[i - 1][0])) % MOD;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int inputs[] = new int[t];
        int maxNum = 0;
        for (int i = 0; i < t; i++) {
            inputs[i] = sc.nextInt();
            maxNum = Math.max(maxNum, inputs[i]);
        }
        dp = new long[maxNum + 1][2];
        populateDP(maxNum);

        for(int i =0;i<t;i++){
            int currN = inputs[i];
            long res = (dp[currN][0]+dp[currN][1])%MOD;
            System.out.println(res);
        }
        sc.close();
    }

}