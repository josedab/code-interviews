package com.josedab.interviewbit.graphs;

import java.util.Arrays;
import java.util.List;

/**
 * Given a 2D board and a word, find if the word exists in the grid.

 The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally
 or vertically neighboring. The cell itself does not count as an adjacent cell.
 The same letter cell may be used more than once.
 See extension {@link WordSearchBoardExtended} solution for restriction related to cell only used once at a maximum

 Example :

 Given board =

 [
 ["ABCE"],
 ["SFCS"],
 ["ADEE"]
 ]
 word = "ABCCED", -> returns 1,
 word = "SEE", -> returns 1,
 word = "ABCB", -> returns 1,
 word = "ABFSAB" -> returns 1
 word = "ABCD" -> returns 0
 Note that 1 corresponds to true, and 0 corresponds to false.
 */
public class WordSearchBoard {

    public int exist(List<String> listStrs, String str) {
        int n = listStrs.size();
        int m = listStrs.get(0).length();
        boolean result = false;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                result = existHelper(listStrs, str, 0, i, j);
                if (result) {
                    return 1;
                }
            }
        }
        return result ? 1 : 0;
    }

    private boolean existHelper(List<String> listStrs, String str,
                                int index, int i, int j) {

        boolean result = false;
        if (index == str.length()) {
            result = true;
        } else if (i >= 0 && i < listStrs.size() && j >= 0 && j < listStrs.get(0).length()) {

            char currentChar = str.charAt(index);
            if (currentChar == listStrs.get(i).charAt(j)) {
                result = result || existHelper(listStrs, str, index + 1, i + 1, j);
                result = result || existHelper(listStrs, str, index + 1, i, j + 1);
                result = result || existHelper(listStrs, str, index + 1, i - 1, j);
                result = result || existHelper(listStrs, str, index + 1, i, j - 1);
            }
        }
        return result;
    }


    public static void main(String[] args) {
        WordSearchBoard solution = new WordSearchBoard();
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
