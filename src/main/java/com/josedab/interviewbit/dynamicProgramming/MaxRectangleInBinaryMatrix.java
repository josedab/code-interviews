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
    public int maximalRectangle(List<List<Integer>> matrix) {
        int[][] dp = new int[matrix.size()][matrix.get(0).size()];
        for (int j = 0; j < matrix.get(0).size(); j++) {
            dp[0][j] = matrix.get(0).get(j);
        }

        int result = maxArea(dp[0]);

        for (int i = 1; i < matrix.size(); i++) {
            for (int j = 0; j < matrix.get(0).size(); j++) {
                if (matrix.get(i).get(j) == 1) {
                    dp[i][j] = matrix.get(i).get(j) + dp[i - 1][j];
                }
            }
            result = Math.max(result, maxArea(dp[i]));
        }
        return result;
    }

    public int maximalRectangleOfficialSolution(List<List<Integer>> matrix) {
        if (matrix.size() == 0) return 0;
        int[][] dp = new int[matrix.size()][matrix.get(0).size()];
        int maxRec = 0;
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                int num = matrix.get(i).get(j);
                if (j == 0) dp[i][j] = num == 1 ? 1 : 0;
                else dp[i][j] = num == 1 ? dp[i][j - 1] + 1 : 0;
                int row = i, width = dp[i][j];
                while (row >= 0 && dp[row][j] > 0) {
                    width = Math.min(width, dp[row][j]);
                    maxRec = Math.max(maxRec, width * (i - row + 1));
                    row--;
                }
            }
        }
        return maxRec;
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
