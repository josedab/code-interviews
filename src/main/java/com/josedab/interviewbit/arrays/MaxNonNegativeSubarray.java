package com.josedab.interviewbit.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Find out the maximum sub-array of non negative numbers from an array.
 The sub-array should be continuous. That is, a sub-array created by choosing
 the second and fourth element and skipping the third element is invalid.

 Maximum sub-array is defined in terms of the sum of the elements in the sub-array.
 Sub-array A is greater than sub-array B if sum(A) > sum(B).

 Example:

 A : [1, 2, 5, -7, 2, 3]
 The two sub-arrays are [1, 2, 5] [2, 3].
 The answer is [1, 2, 5] as its sum is larger than [2, 3]
 NOTE: If there is a tie, then compare with segment's length and return segment which has maximum length
 NOTE 2: If there is still a tie, then return the segment with minimum starting index

 */
public class MaxNonNegativeSubarray {

    public List<Integer> maxset(List<Integer> A) {

        int idxStart = -1;
        int idxEnd = -1;
        long maxSum = 0;

        int start = 0;
        int end = 0;
        long sum = 0;
        for (int i = 0; i < A.size(); i++) {
            if (A.get(i) >= 0) {
                end = i;
                sum += A.get(i);
                if (sum >= maxSum) {
                    if (!(sum == maxSum && (end - start) < (idxEnd - idxStart))) {
                        maxSum = sum;
                        idxEnd = end;
                        idxStart = start;
                    }
                }
            } else {
                sum = 0;
                start = i + 1;
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = idxStart; i <= idxEnd && i >= 0; i++) {
            result.add(A.get(i));
        }
        return result;
    }

    public static void main(String[] args) {
        MaxNonNegativeSubarray solution = new MaxNonNegativeSubarray();
        System.out.println(solution.maxset(Arrays.asList(1, 2, 3, -7, 50)));
        System.out.println(solution.maxset(Arrays.asList(1967513926, 1540383426, -1303455736, -521595368)));
    }
}
