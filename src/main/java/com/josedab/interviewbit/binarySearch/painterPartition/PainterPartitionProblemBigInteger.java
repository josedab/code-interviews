package com.josedab.interviewbit.binarySearch.painterPartition;

import java.math.BigInteger;
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

 Solution that takes into consideration overflows. Implemented with BigInteger
 */
public class PainterPartitionProblemBigInteger {

    private static final BigInteger MOD = BigInteger.valueOf(10000003);
    public int paint(int nPainters, int costPerUnit, List<Integer> list) {
        return paintHelper(nPainters, costPerUnit, list, list.size()).mod(MOD).intValue();
    }

    private BigInteger paintHelper(int nPainters, int costPerUnit, List<Integer> list, int n) {

        BigInteger result = BigInteger.valueOf(Long.MAX_VALUE);
        if (nPainters == 1 || n == 1) {
            return sum(list, 0, n - 1, costPerUnit);
        }

        // find minimum of all possible maximum
        // nPainters-1 partitions to the left of list[i],
        // with i elements, put nPainters-1 th divider
        // between list[i-1] & list[i] to get nPainter-th
        // partition
        for (int i = 1; i <= n; i++) {
            BigInteger sumTmp = sum(list, i, n - 1, costPerUnit);
            result = result.min(
                        paintHelper(nPainters - 1, costPerUnit, list, i)
                                .max(sum(list, i, n - 1, costPerUnit)));
        }

        return result;


    }

    private BigInteger sum(List<Integer> list, int startIndex, int endIndex, int costPerUnit) {
        BigInteger result = BigInteger.ZERO;
        for (int i = startIndex; i <= endIndex; i++) {
            result = result.add(
                    BigInteger.valueOf(list.get(i))
                            .multiply(BigInteger.valueOf(costPerUnit))
                            .mod(MOD))
                    .mod(MOD);

        }
        return result;
    }

    public static void main(String[] args) {
        PainterPartitionProblemBigInteger solution = new PainterPartitionProblemBigInteger();
        System.out.println(solution.paint(2, 5, Arrays.asList(1, 10)));
    }
}
