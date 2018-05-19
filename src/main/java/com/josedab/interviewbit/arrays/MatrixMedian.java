package com.josedab.interviewbit.arrays;

import com.josedab.interviewbit.binarySearch.MatrixMedianBinarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Given a N cross M matrix in which each row is sorted, find the overall median of the matrix. Assume N*M is odd.

 For example,

 Matrix=
 [1, 3, 5]
 [2, 6, 9]
 [3, 6, 9]

 A = [1, 2, 3, 3, 5, 6, 6, 9, 9]

 Median is 5. So, we return 5.
 Note: No restrictions
 For binary search resolution with the restriction of no extra memory allowed,
 see @{@link MatrixMedianBinarySearch}
 */
public class MatrixMedian {
    public int findMedian(List<List<Integer>> matrix) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < matrix.size(); i++) {
            for (int j = 0; j < matrix.get(0).size(); j++) {
                list.add(matrix.get(i).get(j));
            }
        }
        Collections.sort(list);
        int n = list.size();
        return list.get(n / 2);
    }

    public static void main(String[] args) {
        MatrixMedian solution = new MatrixMedian();
        List<List<Integer>> matrix = Arrays.asList(
                Arrays.asList(1, 3, 5),
                Arrays.asList(2, 6, 9),
                Arrays.asList(3, 6, 9)
        );
        System.out.println(solution.findMedian(matrix));
    }
}
