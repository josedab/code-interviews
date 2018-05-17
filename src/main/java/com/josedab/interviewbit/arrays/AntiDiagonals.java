package com.josedab.interviewbit.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Give a N*N square matrix, return an array of its anti-diagonals.
 * Look at the example for more details.

 Example:


 Input:

 1 2 3
 4 5 6
 7 8 9

 Return the following :

 [
 [1],
 [2, 4],
 [3, 5, 7],
 [6, 8],
 [9]
 ]


 Input :
 1 2
 3 4

 Return the following  :

 [
 [1],
 [2, 3],
 [4]
 ]
 */
public class AntiDiagonals {

    public List<List<Integer>> diagonal(List<List<Integer>> matrix) {
        List<List<Integer>> result = new ArrayList<>();
        int n = matrix.size();
        int m = matrix.get(0).size();
        for (int i = 0; i < (n + m - 1); i++) {
            result.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                Integer elem = matrix.get(i).get(j);
                result.get(i + j).add(elem);
            }
        }

        return result;
    }

    public List<List<Integer>> diagonalOfficial(List<List<Integer>> matrix) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < matrix.size() * 2 - 1; i++)
            res.add(new ArrayList<>());

        for (int i = 0; i < matrix.size(); i++) {
            for (int j = 0; j < matrix.get(0).size(); j++) {
                res.get(i + j).add(matrix.get(i).get(j));
            }
        }

        return res;
    }

    public static void main(String[] args) {
        AntiDiagonals solution = new AntiDiagonals();
        List<List<Integer>> matrix = Arrays.asList(
                Arrays.asList(1, 2),
                Arrays.asList(3, 4)
        );
        System.out.println(solution.diagonal(matrix));
        System.out.println(solution.diagonalOfficial(matrix));

    }
}
