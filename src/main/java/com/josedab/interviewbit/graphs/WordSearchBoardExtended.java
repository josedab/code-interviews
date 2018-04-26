package com.josedab.interviewbit.graphs;

import java.util.Arrays;
import java.util.List;

/**
 * Given a 2D board and a word, find if the word exists in the grid.

 The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those
 horizontally or vertically neighboring. The cell itself does not count as an adjacent cell.

 The same letter cell may NOT be used more than once.

 Example :

 Given board =

 [
 ["ABCE"],
 ["SFCS"],
 ["ADEE"]
 ]
 word = "ABCCED", -> returns 1,
 word = "SEE", -> returns 1,
 word = "ABCB", -> returns 0,  // different result as oposed to {@link WordSearchBoard}
 word = "ABFSAB" -> returns 1
 word = "ABCD" -> returns 0
 Note that 1 corresponds to true, and 0 corresponds to false.
 */
public class WordSearchBoardExtended {

    public int exist(List<String> listStrs, String str) {
        int n = listStrs.size();
        int m = listStrs.get(0).length();
        boolean[][] visited = new boolean[n][m];
        boolean result = false;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                result = existHelper(listStrs, str, 0, i, j, visited);
                if (result) {
                    return 1;
                }
            }
        }
        return result ? 1 : 0;
    }

    private boolean existHelper(List<String> listStrs, String str,
                                int index, int i, int j, boolean[][] visited) {

        boolean result = false;
        if (index == str.length()) {
            result = true;
        } else if (i >= 0 && i < listStrs.size() && j >= 0 && j < listStrs.get(0).length() && !visited[i][j]) {

            visited[i][j] = true;
            char currentChar = str.charAt(index);
            if (currentChar == listStrs.get(i).charAt(j)) {
                result = result || existHelper(listStrs, str, index + 1, i + 1, j, visited);
                result = result || existHelper(listStrs, str, index + 1, i, j + 1, visited);
                result = result || existHelper(listStrs, str, index + 1, i - 1, j, visited);
                result = result || existHelper(listStrs, str, index + 1, i, j - 1, visited);
            }

            visited[i][j] = false;
        }
        return result;
    }


    public static void main(String[] args) {
        WordSearchBoardExtended solution = new WordSearchBoardExtended();
        List<String> problem = Arrays.asList(
                "FEDCBECD",
                "FABBGACG",
                "CDEDGAEC",
                "BFFEGGBA",
                "FCEEAFDA",
                "AGFADEAC",
                "ADGDCBAA",
                "EAABDDFF"
        );
        System.out.println(solution.exist(problem, "BCDCB"));

        problem = Arrays.asList(
                "ABCE",
                "SFCS",
                "ADEE"
        );
        System.out.println(solution.exist(problem, "ABCCED"));
        System.out.println(solution.exist(problem, "SEE"));
        System.out.println(solution.exist(problem, "ABCB"));
        System.out.println(solution.exist(problem, "ABCD"));

    }
}
