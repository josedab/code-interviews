package com.josedab.interviewbit.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
 http://i.imgur.com/yaxpgda.png

 N Queens: Example 1

 Given an integer n, return all distinct solutions to the n-queens puzzle.

 Each solution contains a distinct board configuration of the n-queens’ placement, where 'Q' and '.' both indicate a queen and an empty space respectively.

 For example,
 There exist two distinct solutions to the 4-queens puzzle:

 [
 [".Q..",  // Solution 1
 "...Q",
 "Q...",
 "..Q."],

 ["..Q.",  // Solution 2
 "Q...",
 "...Q",
 ".Q.."]
 ]
 */
public class Nqueens {
    public ArrayList<ArrayList<String>> solveNQueens(int a) {
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
        int[] partialSolution = new int[a];
        for (int i = 0; i < a; i++) {
            partialSolution[i] = -1;
        }
        List<int[]> solutions = new LinkedList<int[]>();
        solveNQueensAux(partialSolution, 0, solutions);
        for (int[] solution : solutions) {
            result.add(getArrayOfStringsSolution(solution));
        }
        return result;
    }

    private void solveNQueensAux(int[] partialSolution, int placementOfQueenIndex, List<int[]> solutions) {

        if (placementOfQueenIndex == partialSolution.length) {
            solutions.add(partialSolution.clone());
        } else {
            // Selecting candidates
            for (int i = 0; i < partialSolution.length; i++) {
                if (placementOfQueenIndex == 0) {
                    partialSolution[placementOfQueenIndex] = i;
                    solveNQueensAux(partialSolution, placementOfQueenIndex + 1, solutions);
                } else {
                    // Pruning tree
                    boolean isACandidate = true;
                    for (int j = 0; j < placementOfQueenIndex; j++) {
                        if (i == partialSolution[j]
                                || isDiagonal(j, partialSolution[j], placementOfQueenIndex, i)) {
                            isACandidate = false;
                            break;
                        }
                    }
                    if (isACandidate) {
                        partialSolution[placementOfQueenIndex] = i;
                        solveNQueensAux(partialSolution, placementOfQueenIndex + 1, solutions);
                    }
                }
            }

        }

    }

    private boolean isDiagonal(int i1, int j1, int i2, int j2) {
        return Math.abs(i2 - i1) == Math.abs(j2 - j1);
    }

    private ArrayList<String> getArrayOfStringsSolution(int[] solution) {
        ArrayList<String> result = new ArrayList<String>(solution.length);
        for (int i = 0; i < solution.length; i++) {
            result.add(getStringSolutionForRow(solution[i], solution.length));
        }
        return result;
    }

    private String getStringSolutionForRow(int position, int maxSize) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < maxSize; i++) {
            if (i == position) {
                str.append('Q');
            } else {
                str.append('.');
            }
        }
        return str.toString();
    }

    public static void main(String[] args) {
        Nqueens solution = new Nqueens();
        System.out.println(solution.solveNQueens(4));
    }

}
