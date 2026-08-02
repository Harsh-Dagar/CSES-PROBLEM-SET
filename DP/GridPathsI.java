package DP;
import java.util.*;

public class GridPathsI {

    private static final int MOD = 1_000_000_007;

    private static int countPaths(String[] grid) {
        int n = grid.length;
        int[][] dp = new int[n][n];

        // If destination is blocked
        if (grid[n - 1].charAt(n - 1) == '*') {
            return 0;
        }

        dp[n - 1][n - 1] = 1;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {

                if (grid[i].charAt(j) == '*') {
                    dp[i][j] = 0;
                    continue;
                }

                if (i == n - 1 && j == n - 1) {
                    continue;
                }

                long paths = 0;


                if (i + 1 < n) {
                    paths += dp[i + 1][j];
                }

                if (j + 1 < n) {
                    paths += dp[i][j + 1];
                }

                dp[i][j] = (int) (paths % MOD);
            }
        }

        return dp[0][0];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        String[] grid = new String[n];
        for (int i = 0; i < n; i++) {
            grid[i] = sc.nextLine();
        }

        System.out.println(countPaths(grid));
        sc.close();
    }
}