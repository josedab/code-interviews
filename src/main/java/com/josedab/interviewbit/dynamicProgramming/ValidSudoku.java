package com.josedab.interviewbit.dynamicProgramming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Determine if a Sudoku is valid, according to: http://sudoku.com.au/TheRules.aspx

 The Sudoku board could be partially filled, where empty cells are filled with the character ‘.’.



 The input corresponding to the above configuration :

 ["53..7....", "6..195...", ".98....6.", "8...6...3", "4..8.3..1", "7...2...6", ".6....28.", "...419..5", "....8..79"]
 A partially filled sudoku which is valid.

 Note:
 A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.
 Return 0 / 1 ( 0 for false, 1 for true ) for this problem
 */
public class ValidSudoku {

    public int isValidSudoku(final List<String> sudokuBoard) {
        Map<Integer, Set<Character>> columns = new HashMap<>(); // map to check if cols are valid
        Map<Integer, Set<Character>> rows = new HashMap<>(); // map to check if rows are valid
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) { // we have 9 3x3 squares
                Set<Character> set = new HashSet<>(); // set to check if 3x3 square is valid
                for (int m = 0; m < 3; m++) {
                    for (int n = 0; n < 3; n++) { // for every 3x3 square
                        int c = 3 * j + n;
                        int r = 3 * i + m;

                        char x = sudokuBoard.get(r).charAt(c);

                        if (x == '.') {
                            continue;
                        }

                        if (!columns.containsKey(c)) {
                            columns.put(c, new HashSet<>());
                        }
                        if (!rows.containsKey(r)) {
                            rows.put(r, new HashSet<>());
                        }

                        if (set.contains(x) || columns.get(c).contains(x) || rows.get(r).contains(x)) {
                            return 0;
                        } else {
                            set.add(x);
                            columns.get(c).add(x);
                            rows.get(r).add(x);
                        }
                    }
                }
            }
        }

        return 1;
    }

    public static void main(String[] args) {
        ValidSudoku solution = new ValidSudoku();
        List<String> sudokuBoard = Arrays.asList(
                "53..7....",
                "6..195...",
                ".98....6.",
                "8...6...3",
                "4..8.3..1",
                "7...2...6",
                ".6....28.",
                "...419..5",
                "....8..79"
        );
        System.out.println(solution.isValidSudoku(sudokuBoard));
    }
}
