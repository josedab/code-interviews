package com.josedab.interviewbit.dynamicProgramming;

import java.util.Arrays;
import java.util.List;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.

 If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.

 Example :

 Input : [1 2]
 Return :  1
 */
public class BestTimeToBuyAndSellStocksI {
    public int maxProfit(final List<Integer> A) {
        int min = Integer.MAX_VALUE;
        int max = 0;

        for (int i = 0; i < A.size(); i++) {
            min = Math.min(min, A.get(i));
            max = Math.max(max, A.get(i) - min);
        }
        return max;
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStocksI solution = new BestTimeToBuyAndSellStocksI();
        System.out.println(solution.maxProfit(Arrays.asList(1, 2)));
    }
}
