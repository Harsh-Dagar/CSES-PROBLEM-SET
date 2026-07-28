package DP;
import java.util.Scanner;

public final class DiceCombinations {

    private static final int MOD = 1_000_000_007;
    private static final int MAX_DICE_FACE = 6;

    private DiceCombinations() {
    }

    private static int countWays(int target) {
        int[] dp = new int[target + 1];

        dp[0] = 1;

        for(int sum = 1; sum <= target; sum++){
            long ways = 0;

            for(int dice = 1; dice <= MAX_DICE_FACE; dice++){
                if(sum-dice>=0){
                    ways = (ways+dp[sum-dice])%MOD;
                }
            }
            
            dp[sum] = (int)ways%MOD;
        }
        return dp[target];
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            System.out.println(countWays(n));
        }
    }
}