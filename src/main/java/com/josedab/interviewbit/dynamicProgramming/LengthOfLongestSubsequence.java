package com.josedab.interviewbit.dynamicProgramming;

import java.util.Arrays;
import java.util.List;

/**
 * Given an array of integers, find the length of longest subsequence which is first increasing then decreasing.
 * <p>
 * *Example: **
 * <p>
 * For the given array [1 11 2 10 4 5 2 1]
 * <p>
 * Longest subsequence is [1 2 10 4 2 1]
 * <p>
 * Return value 6
 */
public class LengthOfLongestSubsequence {
    public int longestSubsequenceLength(final List<Integer> A) {
        int[] dpIncr = new int[A.size()];
        int[] dpDecr = new int[A.size()];

        if (A.size() == 0) {
            return 0;
        }

        // Calculation of Longest increasing subsequence
        dpIncr[0] = 1;
        for (int i = 1; i < A.size(); i++) {
            int result = 1;
            for (int j = 0; j < i; j++) {
                result = Math.max(result, (A.get(i) > A.get(j)) ? 1 + dpIncr[j] : 1);
            }
            dpIncr[i] = result;
        }

        // Calculation of Longest decreasing subsequence
        dpDecr[A.size() - 1] = 1;
        for (int i = A.size() - 1; i >= 0; i--) {
            int result = 1;
            for (int j = A.size() - 1; j > i; j--) {
                result = Math.max(result, (A.get(i) > A.get(j)) ? 1 + dpDecr[j] : 1);
            }
            dpDecr[i] = result;
        }

        // Result is the max of the combination of both {increasing, decreasing} subsequence for each element
        int result = -1;
        for (int i = 0; i < A.size(); i++) {
            int incr = dpIncr[i];
            int decr = dpDecr[i];
            result = Math.max(result, incr + decr - 1);
        }
        return result;
    }

    public static void main(String[] args) {
        LengthOfLongestSubsequence solution = new LengthOfLongestSubsequence();
        System.out.println(solution.longestSubsequenceLength(Arrays.asList(1, 11, 2, 10, 4, 5, 2, 1)));
    }
}
