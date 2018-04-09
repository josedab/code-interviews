package com.josedab.interviewbit.dynamicProgramming;

import java.util.Arrays;
import java.util.List;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.

 Design an algorithm to find the maximum profit. You may complete at most two transactions.

 Note:
 You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).

 Example :

 Input : [1 2 1 2]
 Output : 2

 Explanation :
 Day 1 : Buy
 Day 2 : Sell
 Day 3 : Buy
 Day 4 : Sell

 Solution:
 https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/discuss/39611/Is-it-Best-Solution-with-O(n)-O(1).

 */
public class BestTimeToBuyAndSellStocksIII {

    public int maxProfit(final List<Integer> prices) {

        int oneBuy = Integer.MIN_VALUE;
        int oneBuyOneSell = 0;
        int twoBuy = Integer.MIN_VALUE;
        int twoBuyTwoSell = 0;
        for (int i = 0; i < prices.size(); i++) {
            oneBuy = Math.max(oneBuy, -prices.get(i));
            oneBuyOneSell = Math.max(oneBuyOneSell, prices.get(i) + oneBuy);
            twoBuy = Math.max(twoBuy, oneBuyOneSell - prices.get(i));
            twoBuyTwoSell = Math.max(twoBuyTwoSell, twoBuy + prices.get(i));
        }

        return Math.max(oneBuyOneSell, twoBuyTwoSell);
    }

    // Solution for at most maxTransactions
    public int maxProfitForKTransactions(int maxTransactions, List<Integer> prices) {

        int[] buy = new int[maxTransactions + 1];
        int[] sell = new int[maxTransactions + 1];

        for (int i = 0; i < buy.length; i++)
            buy[i] = Integer.MIN_VALUE;

        for (int p : prices) {
            for (int i = maxTransactions; i >= 1; i--) {
                sell[i] = Math.max(sell[i], buy[i] + p);
                buy[i] = Math.max(buy[i], sell[i - 1] - p);
            }
        }
        return sell[maxTransactions];
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStocksIII solution = new BestTimeToBuyAndSellStocksIII();
        System.out.println(solution.maxProfit(Arrays.asList(1, 2, 1, 2)));
        System.out.println(solution.maxProfitForKTransactions(2, Arrays.asList(1, 2, 1, 2)));
    }
}
