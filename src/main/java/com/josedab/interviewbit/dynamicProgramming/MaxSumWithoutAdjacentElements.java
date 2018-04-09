package com.josedab.interviewbit.dynamicProgramming;

import java.util.Arrays;
import java.util.List;

/**
 * Given a 2 * N Grid of numbers, choose numbers such that the sum of the numbers
 is maximum and no two chosen numbers are adjacent horizontally, vertically or diagonally, and return it.

 Example:

 Grid:
 1 2 3 4
 2 3 4 5
 so we will choose
 3 and 5 so sum will be 3 + 5 = 8


 Note that you can choose more than 2 numbers


 */
public class MaxSumWithoutAdjacentElements {
    public int adjacent(List<List<Integer>> A) {
        int[][] dp = new int[A.size()][A.get(0).size()];
        int result = 0;

        for (int i = 0; i < A.get(0).size(); i++) {
            if (i == 0) {
                dp[0][i] = Math.max(0, A.get(0).get(i));
                dp[1][i] = Math.max(0, A.get(1).get(i));
            } else if (i == 1) {
                dp[0][i] = Math.max(Math.max(dp[0][i - 1], dp[1][i - 1]),
                        A.get(0).get(i));
                dp[1][i] = Math.max(Math.max(dp[0][i - 1], dp[1][i - 1]),
                        A.get(1).get(i));
            } else if (i > 1) {
                dp[0][i] = Math.max(Math.max(dp[0][i - 1], dp[1][i - 1]),
                        A.get(0).get(i) + Math.max(dp[0][i - 2], dp[1][i - 2]));
                dp[1][i] = Math.max(Math.max(dp[0][i - 1], dp[1][i - 1]),
                        A.get(1).get(i) + Math.max(dp[0][i - 2], dp[1][i - 2]));
            }
            result = Math.max(result, Math.max(dp[0][i], dp[1][i]));
        }
        return result;
    }

    public static void main(String[] args) {
        MaxSumWithoutAdjacentElements solution = new MaxSumWithoutAdjacentElements();
        List<List<Integer>> problem = Arrays.asList(
                Arrays.asList(1, 2, 3, 4),
                Arrays.asList(2, 3, 4, 5)
        );
        System.out.println(solution.adjacent(problem));
    }
}
