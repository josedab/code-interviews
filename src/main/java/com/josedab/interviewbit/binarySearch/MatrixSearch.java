package com.josedab.interviewbit.binarySearch;

import java.util.Arrays;
import java.util.List;

/**
 * Consider the following matrix:

 [
 [1,   3,  5,  7],
 [10, 11, 16, 20],
 [23, 30, 34, 50]
 ]
 Given target = 3, return 1 ( 1 corresponds to true )

 Return 0 / 1 ( 0 if the element is not present, 1 if the element is present ) for this problem


 */
public class MatrixSearch {

    public int searchMatrix(List<List<Integer>> matrix, int target) {

        int i = 0, j = matrix.get(0).size() - 1;  //set indexes for top right element

        while (i < matrix.size() && j >= 0) {
            int element = matrix.get(i).get(j);
            if (element == target) {
                return 1;
            } else if (element > target) {
                // Next item in the row
                // At this point we could do binary search on the array
                // TODO: benchmark this work against a completely binary search approach
                j--;
            } else {
                // Next row
                i++;
            }
        }

        return 0;

    }

    public int searchMatrixBinarySearch(List<List<Integer>> matrix, int target) {
        if (matrix.size() < 1) return 0;

        int rowLength = matrix.get(0).size();

        int start = 0;
        int end = (matrix.size() * rowLength) - 1;
        int middle;
        int rowIdx;
        int colIdx;
        while (start <= end) {
            middle = start + ((end - start) / 2);
            rowIdx = middle / rowLength;
            colIdx = middle % rowLength;
            if (matrix.get(rowIdx).get(colIdx) == target) {
                return 1;
            } else if (matrix.get(rowIdx).get(colIdx) > target) {
                end = middle - 1;
            } else {
                start = middle + 1;
            }
        }

        return 0;


    }


    public static void main(String[] args) {
        MatrixSearch solution = new MatrixSearch();
        List<List<Integer>> problem = Arrays.asList(
                Arrays.asList(1, 3, 5, 7),
                Arrays.asList(10, 11, 16, 20),
                Arrays.asList(23, 30, 34, 50)
        );
        System.out.println(solution.searchMatrix(problem, 3));
        System.out.println(solution.searchMatrixBinarySearch(problem, 3));
    }

}
