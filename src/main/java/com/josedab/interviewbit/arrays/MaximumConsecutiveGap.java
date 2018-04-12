package com.josedab.interviewbit.arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Given an unsorted array, find the maximum difference between the successive elements in its sorted form.

 Try to solve it in linear time/space.

 Example :

 Input : [1, 10, 5]
 Output : 5
 Return 0 if the array contains less than 2 elements.

 You may assume that all the elements in the array are non-negative integers and fit in the 32-bit signed integer range.
 You may also assume that the difference will not overflow.

 Official solution by InterviewBit is {@link MaximumConsecutiveGapBucket}
 */
public class MaximumConsecutiveGap {

    // Solution O(n logn)
    public int maximumGap(final List<Integer> A) {
        Collections.sort(A);
        int result = 0;
        for (int i = 1; i < A.size(); i++) {
            result = Math.max(result, A.get(i) - A.get(i - 1));
        }
        return result;
    }

    public static void main(String[] args) {
        MaximumConsecutiveGap solution = new MaximumConsecutiveGap();
        System.out.println(solution.maximumGap(Arrays.asList(1, 10, 5)));
    }
}
