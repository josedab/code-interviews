package com.josedab.interviewbit.arrays;

import java.util.Arrays;
import java.util.List;

/*

 Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

 For example:

 Given the array [-2,1,-3,4,-1,2,1,-5,4],
 the contiguous subarray [4,-1,2,1] has the largest sum = 6.
 For this problem, return the maximum sum.

 */
public class MaxSumContiguousSubArray {

    public static int maxSubArray(final List<Integer> a) {
        int result = Integer.MIN_VALUE;
        int partialMax = 0;
        for (int element : a) {
            int maxToConsider = partialMax + element;
            partialMax = Math.max(element, maxToConsider);
            result = Math.max(result, partialMax);
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(-2, 1, -3, 4, -1, 2, 1, -5, 4);
        System.out.println(MaxSumContiguousSubArray.maxSubArray(list));
    }
}
