package com.josedab.interviewbit.dynamicProgramming;

import java.util.Arrays;
import java.util.List;

/**
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

 Note: You can only move either down or right at any point in time.
 Example :

 Input :

 [  1 3 2
 4 3 1
 5 6 1
 ]

 Output : 8
 1 -> 3 -> 2 -> 1 -> 1

 */
public class MinSumPathInMatrix {

    public int minPathSum(List<List<Integer>> A) {
        int[][] matrixCost = new int[A.size()][A.get(0).size()];

        for (int i = 0; i < A.size(); i++) {
            List<Integer> rowData = A.get(i);

            for (int j = 0; j < A.get(0).size(); j++) {
                if (i == 0 && j == 0) {
                    matrixCost[i][j] = rowData.get(0);
                } else if (i == 0) {
                    matrixCost[i][j] = matrixCost[i][j - 1] + rowData.get(j);
                } else if (j == 0) {
                    matrixCost[i][j] = matrixCost[i - 1][j] + rowData.get(j);
                } else {
                    matrixCost[i][j] = rowData.get(j) + Math.min(matrixCost[i][j - 1], matrixCost[i - 1][j]);
                }
            }

        }
        return matrixCost[A.size() - 1][A.get(0).size() - 1];
    }

    public static void main(String[] args) {
        MinSumPathInMatrix solution = new MinSumPathInMatrix();
        List<List<Integer>> problem = Arrays.asList(
                Arrays.asList(1, 3, 2),
                Arrays.asList(4, 3, 1),
                Arrays.asList(5, 6, 1)
        );
        System.out.println(solution.minPathSum(problem));
    }
}
