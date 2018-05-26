package com.josedab.interviewbit.binarySearch.painterPartition;

import java.util.Arrays;
import java.util.List;

/**
 * You have to paint N boards of length {A0, A1, A2, A3 … AN-1}.
 * There are K painters available and you are also given how much time a painter takes to paint 1 unit of board.
 * You have to get this job done as soon as possible under the constraints that any painter
 * will only paint contiguous sections of board.

     2 painters cannot share a board to paint. That is to say, a board
     cannot be painted partially by one painter, and partially by another.
     A painter will only paint contiguous boards. Which means a
     configuration where painter 1 paints board 1 and 3 but not 2 is
     invalid.
     Return the ans % 10000003

     Input :
     K : Number of painters
     T : Time taken by painter to paint 1 unit of board
     L : A List which will represent length of each board

     Output:
     return minimum time to paint all boards % 10000003
     Example

     Input :
     K : 2
     T : 5
     L : [1, 10]
     Output : 50

 Does not take into consideration overflows. Most of the scenarios and easy to write.
 For overflow consideration, see {@link PainterPartitionProblemBigInteger}
 For optimized binary search approach see {@link PainterPartitionProblemOfficial}
 */
public class PainterPartitionProblem {
    public int paint(int nPainters, int costPerUnit, List<Integer> list) {
        return paintHelper(nPainters, costPerUnit, list, list.size());
    }

    private int paintHelper(int nPainters, int costPerUnit, List<Integer> list, int n) {

        int result = Integer.MAX_VALUE;
        if (nPainters == 1 || n == 1) {
            return sum(list, 0, n - 1, costPerUnit);
        }

        // find minimum of all possible maximum
        // nPainters-1 partitions to the left of list[i],
        // with i elements, put nPainters-1 th divider
        // between list[i-1] & list[i] to get nPainter-th
        // partition
        for (int i = 1; i <= n; i++)
            result = Math.min(result,
                    Math.max(paintHelper(nPainters - 1, costPerUnit, list, i),
                            sum(list, i, n - 1, costPerUnit)));

        return result;


    }

    private int sum(List<Integer> list, int startIndex, int endIndex, int costPerUnit) {
        int result = 0;
        for (int i = startIndex; i <= endIndex; i++) {
            result = result + list.get(i) * costPerUnit;
        }
        return result;
    }

    public static void main(String[] args) {
        PainterPartitionProblem solution = new PainterPartitionProblem();
        System.out.println(solution.paint(2, 5, Arrays.asList(1, 10)));
    }
}
