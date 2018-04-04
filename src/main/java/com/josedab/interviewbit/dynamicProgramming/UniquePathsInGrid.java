package com.josedab.interviewbit.dynamicProgramming;

import java.util.Arrays;
import java.util.List;

/**
 * Given a grid of size m * n, lets assume you are starting at (1,1) and your goal is to reach (m,n). At any instance, if you are on (x,y), you can either go to (x, y + 1) or (x + 1, y).

 Now consider if some obstacles are added to the grids. How many unique paths would there be?
 An obstacle and empty space is marked as 1 and 0 respectively in the grid.

 Example :
 There is one obstacle in the middle of a 3x3 grid as illustrated below.

 [
 [0,0,0],
 [0,1,0],
 [0,0,0]
 ]
 The total number of unique paths is 2.

 Note: m and n will be at most 100. 
 */
public class UniquePathsInGrid {
    public int uniquePathsWithObstacles(List<List<Integer>> A) {
        int[][] paths = new int[A.size()][A.get(0).size()];
        paths[0][0] = (A.get(0).get(0) != 1) ? 1 : 0;

        for (int j = 1; j < A.size(); j++) {
            if (A.get(j).get(0) != 1) paths[j][0] = paths[j - 1][0];
        }

        for (int j = 1; j < A.get(0).size(); j++) {
            if (A.get(0).get(j) != 1) paths[0][j] = paths[0][j - 1];
        }

        for (int i = 1; i < A.size(); i++) {
            List<Integer> row = A.get(i);
            for (int j = 1; j < A.get(0).size(); j++) {
                int element = row.get(j);
                if (element != 1) {
                    paths[i][j] = paths[i - 1][j] + paths[i][j - 1];
                }
            }
        }
        return paths[A.size() - 1][A.get(0).size() - 1];
    }

    public static void main(String[] args) {
        UniquePathsInGrid solution = new UniquePathsInGrid();
        List<List<Integer>> problem = Arrays.asList(
                Arrays.asList(0, 0, 0),
                Arrays.asList(0, 1, 0),
                Arrays.asList(0, 0, 0)
        );
        solution.uniquePathsWithObstacles(problem);
    }
}
