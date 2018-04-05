package com.josedab.interviewbit.greedy;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Given an array of integers, return the highest product possible by multiplying 3 numbers from the array
 * <p>
 * Input:
 * <p>
 * array of integers e.g {1, 2, 3}
 * NOTE: Solution will fit in a 32-bit signed integer
 * Example:
 * <p>
 * [0, -1, 3, 100, 70, 50]
 * <p>
 * => 70*50*100 = 350000
 */
public class HighestProduct {

    // O(nlogn)
    public int maxp3(List<Integer> A) {
        Collections.sort(A);
        int max1 = A.get(A.size() - 1);
        int max2 = A.get(A.size() - 2);
        int max3 = A.get(A.size() - 3);
        int min1 = A.get(0);
        int min2 = A.get(1);

        return Math.max(max1 * max2 * max3, min1 * min2 * max1);
    }

    // Solution given by editorial O(n)
    // Less readable, more efficient
    public int maxp3Official(List<Integer> a) {
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;

        for (Integer i : a) {
            if (i > max3 && i <= max2) {
                max3 = i;
            } else if (i > max2 && i <= max1) {
                max3 = max2;
                max2 = i;
            } else if (i > max1) {
                max3 = max2;
                max2 = max1;
                max1 = i;
            }

            if (i >= min1 && i < min2) {
                min2 = i;
            } else if (i < min1) {
                min2 = min1;
                min1 = i;
            }
        }

        return Math.max(max1 * max2 * max3, max1 * min1 * min2);
    }

    public static void main(String[] args) {
        HighestProduct solution = new HighestProduct();
        System.out.println(solution.maxp3(Arrays.asList(0, -1, 3, 100, 70, 50)));
        System.out.println(solution.maxp3(Arrays.asList(-1, -2, -3, -4, -5)));

    }
}
