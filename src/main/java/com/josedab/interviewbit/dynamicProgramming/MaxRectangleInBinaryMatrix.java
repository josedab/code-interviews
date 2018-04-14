package com.josedab.interviewbit.dynamicProgramming;

import java.util.Arrays;
import java.util.List;

/**
 * Given a 2D binary matrix filled with 0’s and 1’s, find the largest rectangle containing all ones and return its area.

 Bonus if you can solve it in O(n^2) or less.

 Example :

 A : [
 1 1 1
 0 1 1
 1 0 0
 ]

 Output : 4

 As the max area rectangle is created by the 2x2 rectangle created by (0,1), (0,2), (1,1) and (1,2)

 */
public class MaxRectangleInBinaryMatrix {
    public int maximalRectangle(List<List<Integer>> A) {
        int[][] dp = new int[A.size()][A.get(0).size()];
        for (int j = 0; j < A.get(0).size(); j++) {
            dp[0][j] = A.get(0).get(j);
        }

        int result = maxArea(dp[0]);

        for (int i = 1; i < A.size(); i++) {
            for (int j = 0; j < A.get(0).size(); j++) {
                if (A.get(i).get(j) == 1) {
                    dp[i][j] = A.get(i).get(j) + dp[i - 1][j];
                }
            }
            result = Math.max(result, maxArea(dp[i]));
        }
        return result;
    }


    // Naive solution for calculating max area of a histogram
    // This problem extrapolates to the Container With most water problem
    // O(n^2)
    private int maxArea(int[] row) {
        int solution = 0;
        for (int i = 0; i < row.length; i++) {

            if (row[i] != 0) {
                solution = Math.max(solution, row[i]);
                int min = row[i];
                for (int j = i + 1; j < row.length; j++) {
                    if (row[j] != 0) {
                        int base = j - i + 1;
                        min = Math.min(min, row[j]);
                        solution = Math.max(solution, base * min);
                    } else {
                        break;
                    }
                }
            }
        }
        return solution;
    }

    public static void main(String[] args) {
        MaxRectangleInBinaryMatrix solution = new MaxRectangleInBinaryMatrix();
        List<List<Integer>> problem = Arrays.asList(
                Arrays.asList(1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1),
                Arrays.asList(1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1),
                Arrays.asList(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1),
                Arrays.asList(0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1),
                Arrays.asList(1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1),
                Arrays.asList(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1),
                Arrays.asList(1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1),
                Arrays.asList(1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 0, 1, 0),
                Arrays.asList(1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0, 1, 0, 1),
                Arrays.asList(1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1),
                Arrays.asList(1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1),
                Arrays.asList(1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1),
                Arrays.asList(1, 1, 1, 0, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1),
                Arrays.asList(1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1),
                Arrays.asList(1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1)
        );
        System.out.println(solution.maximalRectangle(problem));

        problem = Arrays.asList(Arrays.asList(1));
        System.out.println(solution.maximalRectangle(problem));

        problem = Arrays.asList(
                Arrays.asList(0, 0),
                Arrays.asList(1, 1),
                Arrays.asList(1, 0),
                Arrays.asList(1, 0),
                Arrays.asList(0, 1),
                Arrays.asList(0, 1),
                Arrays.asList(0, 1)
        );
        System.out.println(solution.maximalRectangle(problem));
    }
}
