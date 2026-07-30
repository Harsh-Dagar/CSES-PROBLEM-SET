package DP;

import java.util.*;

public class RemovingDigits {

    static int findMinSteps(int n) {

        int dp[] = new int[n + 1];

        for (int i = 1; i < Math.min(10,n+1); i++) {
            dp[i] = 1;
        }
        dp[0] = 0;

        for (int i = 10; i <= n; i++) {
            int minWays = Integer.MAX_VALUE;
            int currVal = i;
            while(currVal>0){
                int dig = currVal%10;
                if(dig!=0)
                minWays = Math.min(minWays,dp[i-dig]+1);
                currVal = currVal/10;
            }
            dp[i] = minWays;
        }
        return dp[n];
    }

    public static void main(String args[]) {

        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();

            int res = findMinSteps(n);
            System.out.println(res);
        }
    }
}