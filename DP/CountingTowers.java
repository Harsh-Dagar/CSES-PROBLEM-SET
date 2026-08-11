// package DP;
import java.util.*;


public class CountingTowers {

    static final int MOD = (int)1e9+7;

    static int solve(int n){
        long dp[][] = new long[n+1][2];
        dp[1][0]=1;
        dp[1][1]=1;
        //0->split
        //1->not split
        for(int i = 2;i<=n;i++){
            //non split case 
            dp[i][1] = ((2*dp[i-1][1])+(dp[i-1][0]))%MOD;
            //split case
            dp[i][0] = ((dp[i-1][1])+(4*dp[i-1][0]))%MOD;
        }
        return (int)(dp[n][0]+dp[n][1])%MOD;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0){
            int n = sc.nextInt();
            int res = solve(n);
            System.out.println(res);
            t=t-1;
        }
        sc.close();
    }
    
}