package com.josedab.interviewbit.graphs;

import java.util.Arrays;
import java.util.List;

/**
 * Given N * M field of O's and X's, where O=white, X=black
 Return the number of black shapes. A black shape consists of one or more adjacent X's (diagonals not included)

 Example:

 OOOXOOO
 OOXXOXO
 OXOOOXO

 answer is 3 shapes are  :
 (i)    X
 X X
 (ii)
 X
 (iii)
 X
 X
 Note that we are looking for connected shapes here.

 For example,

 XXX
 XXX
 XXX
 is just one single connected black shape.


 */
public class BlackShapes {

    private static final char BLACK_SHAPE = 'X';
    
    public int black(List<String> strs) {
        int[][] matrix = new int[strs.size()][strs.get(0).length()];
        int counter = 0;
        for (int i = 0; i < strs.size(); i++) {
            String str = strs.get(i);
            for (int j = 0; j < strs.get(0).length(); j++) {
                if (matrix[i][j] == 0 && str.charAt(j) == BLACK_SHAPE) {
                    counter++;
                    dfs(matrix, counter, i, j, strs);
                }
            }
        }
        return counter;
    }

    private void dfs(int[][] matrix, int counter, int i, int j, List<String> strs) {
        if (matrix[i][j] == 0 && strs.get(i).charAt(j) == BLACK_SHAPE) {
            matrix[i][j] = counter;

            if (i - 1 >= 0) {
                dfs(matrix, counter, i - 1, j, strs);
            }

            if (j - 1 >= 0) {
                dfs(matrix, counter, i, j - 1, strs);
            }

            if (i + 1 < strs.size()) {
                dfs(matrix, counter, i + 1, j, strs);
            }

            if (j + 1 < strs.get(0).length()) {
                dfs(matrix, counter, i, j + 1, strs);
            }
        }
    }

    public static void main(String[] args) {
        BlackShapes solution = new BlackShapes();
        List<String> problem = Arrays.asList(
                "OOOXOOO",
                "OOXXOXO",
                "OXOOOXO"
                );
        System.out.println(solution.black(problem));
    }
}
