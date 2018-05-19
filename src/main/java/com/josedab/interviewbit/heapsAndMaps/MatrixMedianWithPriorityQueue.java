package com.josedab.interviewbit.heapsAndMaps;

import com.josedab.interviewbit.binarySearch.MatrixMedianBinarySearch;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

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
 For simple solution see {@link com.josedab.interviewbit.arrays.MatrixMedian}
 */
public class MatrixMedianWithPriorityQueue {
    public int findMedian(List<List<Integer>> matrix) {
        if (matrix == null || matrix.size() == 0)
            return 0;

        int n = matrix.size();
        int m = matrix.get(0).size();
        int middleIdx = n * m / 2;

        PriorityQueue<List<Integer>> queue = new PriorityQueue<>(n, new Comparator<List<Integer>>() {
            public int compare(List<Integer> a1, List<Integer> a2) {
                return Integer.compare(a1.get(0), a2.get(0));
            }
        });

        for (int i = 0; i < n; i++) {
            queue.offer(matrix.get(i));
        }

        int idx = 0;
        int num = 0;
        while (idx <= middleIdx) {
            List<Integer> row = queue.poll();
            num = row.remove(0);
            if (row.size() > 0)
                queue.offer(row);
            idx++;
        }
        return num;
    }

    public static void main(String[] args) {
        MatrixMedianWithPriorityQueue solution = new MatrixMedianWithPriorityQueue();
        List<List<Integer>> matrix = Arrays.asList(
                Arrays.asList(1, 3, 5),
                Arrays.asList(2, 6, 9),
                Arrays.asList(3, 6, 9)
        );
        System.out.println(solution.findMedian(matrix));
    }
}
