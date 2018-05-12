package com.josedab.interviewbit.dynamicProgramming;

import java.util.Arrays;
import java.util.List;

/**
 * Find the contiguous subarray within an array (containing at least one number) which has the largest product.
 Return an integer corresponding to the maximum product possible.

 Example :

 Input : [2, 3, -2, 4]
 Return : 6

 Possible with [2, 3]
 */
public class MaxProductSubarray {
    public int maxProduct(final List<Integer> list) {
        int max = 1;
        int min = 1;
        int result = 0;

        for (int i = 0; i < list.size(); i++) {
            int element = list.get(i);

            max = max == 0 ? 1 : max;
            min = min == 0 ? 1 : min;

            if (element > 0) {
                max = max * element;
                min = Math.min(min * element, 1);
            } else if (element == 0) {
                max = 0;
                min = 0;
            } else {
                int temp = max;
                max = Math.max(min * element, 0);
                min = temp * element;
            }

            result = Math.max(result, max);
        }

        return result;
    }

    public static void main(String[] args) {
        MaxProductSubarray solution = new MaxProductSubarray();
        System.out.println(solution.maxProduct(Arrays.asList(2, 3, -2, 4)));
        System.out.println(solution.maxProduct(Arrays.asList(0)));
        System.out.println(solution.maxProduct(Arrays.asList(-5, -4)));

    }
}
