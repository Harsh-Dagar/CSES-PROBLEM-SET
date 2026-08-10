package DP;

import java.util.*;

public class BookShop {

    static long findMaxNumOfPages(int[] bookPrice, int[] pages, int maxMoney) {

        int numBooks = bookPrice.length;

        long dp[] = new long[maxMoney + 1];
        long dp2[] = new long[maxMoney + 1];

        for (int i = 0; i < numBooks; i++) {
            for (int currMoney = 1; currMoney <= maxMoney; currMoney++) {
                long currValue = dp[currMoney];

                if (currMoney >= bookPrice[i]) {
                    currValue = Math.max(currValue, dp[currMoney - bookPrice[i]] + pages[i]);
                }
                dp2[currMoney] = currValue;
            }
            for (int j = 0; j <= maxMoney; j++) {
                dp[j] = dp2[j];
            }
        }
        return dp[maxMoney];
    }

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {
            int numBooks = sc.nextInt();
            int maxMoney = sc.nextInt();

            int[] price = new int[numBooks];
            int[] numPages = new int[numBooks];

            for (int i = 0; i < numBooks; i++) {
                price[i] = sc.nextInt();
            }

            for (int i = 0; i < numBooks; i++) {
                numPages[i] = sc.nextInt();
            }

            long res = findMaxNumOfPages(price, numPages, maxMoney);
            System.out.println(res);

        }

    }

}