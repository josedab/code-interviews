package com.josedab.interviewbit.binarySearch;

import java.util.Arrays;
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
 Note: No extra memory is allowed.
 For other solutions, see {@link com.josedab.interviewbit.arrays.MatrixMedian}
 */
public class MatrixMedianBinarySearch {

    public int findMedian(List<List<Integer>> matrix) {
        int n = matrix.size();
        if (n == 0) return -1;
        int m = matrix.get(0).size();
        int startValue = 0;
        int endValue = Integer.MAX_VALUE;
        int x = 1;
        while (startValue <= endValue) {
            int mid = (startValue + endValue) / 2;
            if (isLessThanHalf(matrix, mid)) {
                startValue = mid + 1;
            } else {
                x = mid;
                endValue = mid - 1;
            }
        }
        return x;
    }

    boolean isLessThanHalf(List<List<Integer>> matrix, int num) {
        int n = matrix.size();
        int m = matrix.get(0).size();
        int count = 0;

        for (int i = 0; i < n; i++) {
            count += getCount(matrix.get(i), num);
        }
        return count < (n * m) / 2 + 1;
    }

    int getCount(List<Integer> row, int n) {
        int start = 0;
        int end = row.size() - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (row.get(mid) > n) end = mid - 1;
            else start = mid + 1;
        }
        return start;
    }

    public static void main(String[] args) {
        MatrixMedianBinarySearch solution = new MatrixMedianBinarySearch();
        List<List<Integer>> matrix = Arrays.asList(
                Arrays.asList(1, 3, 5),
                Arrays.asList(2, 6, 9),
                Arrays.asList(3, 6, 9)
        );
        System.out.println(solution.findMedian(matrix));
    }
}
