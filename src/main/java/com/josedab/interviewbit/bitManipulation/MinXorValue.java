package com.josedab.interviewbit.bitManipulation;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Given an array of N integers, find the pair of integers in the array which have minimum XOR value. Report the minimum XOR value.

 Examples :
 Input
 0 2 5 7
 Output
 2 (0 XOR 2)
 Input
 0 4 7 9
 Output
 3 (4 XOR 7)

 Constraints:
 2 <= N <= 100 000
 0 <= A[i] <= 1 000 000 000
 */
public class MinXorValue {

    // O(n*log(n))
    public int findMinXor(List<Integer> A) {
        Collections.sort(A);
        int solution = Integer.MAX_VALUE;
        for (int i = 0; i < A.size() - 1; i++) {
            solution = Math.min(solution, A.get(i) ^ A.get(i + 1));
        }
        return solution;
    }

    // O(n^2)
    public int findMinXorV2(List<Integer> A) {
        int solution = Integer.MAX_VALUE;
        for (int i = 0; i < A.size() - 1; i++) {
            for (int j = i + 1; j < A.size(); j++) {
                solution = Math.min(solution, A.get(i) ^ A.get(j));
            }
        }
        return solution;
    }

    public static void main(String[] args) {
        MinXorValue solution = new MinXorValue();
        System.out.println(solution.findMinXor(Arrays.asList(0, 2, 5, 7)));
    }
}
