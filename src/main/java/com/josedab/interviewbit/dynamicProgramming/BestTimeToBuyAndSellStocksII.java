package com.josedab.interviewbit.dynamicProgramming;

import java.util.Arrays;
import java.util.List;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.

 Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times). However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).

 Example :

 Input : [1 2 3]
 Return : 2

 Interesting read:
 https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/solution/
 Goes from brute force (O(n^n)) to greedy (O(n))
 */
public class BestTimeToBuyAndSellStocksII {
    private static final int BUY = 0;
    private static final int SELL = 1;


    public int maxProfit(final List<Integer> A) {
        int result = 0;
        for (int i = 1; i < A.size(); i++) {
            if (A.get(i) > A.get(i - 1)) {
                result += (A.get(i) - A.get(i - 1));
            }
        }
        return result;
    }

    // DP alternative solution (O(n^2)
    // To verify with more use cases
    public int maxProfitDp(final List<Integer> A) {
        int[][] dp = new int[2][A.size()];
        for (int i = 0; i < A.size(); i++) {
            if (i == 0) {
                dp[BUY][i] = 0;
                dp[SELL][i] = 0;
            } else {
                dp[BUY][i] = Math.max(dp[BUY][i - 1], dp[SELL][i - 1]);
                for (int j = 0; j < i; j++) {
                    dp[SELL][i] = Math.max(dp[SELL][i], dp[BUY][j] + (A.get(i) - A.get(j)));
                }
            }
        }
        return dp[SELL][A.size() - 1];
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStocksII solution = new BestTimeToBuyAndSellStocksII();
        System.out.println(solution.maxProfit(Arrays.asList(1, 2, 3)));
    }
}
