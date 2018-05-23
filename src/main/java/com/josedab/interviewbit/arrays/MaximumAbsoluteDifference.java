package com.josedab.interviewbit.arrays;

import java.util.Arrays;
import java.util.List;

/**
 * You are given an array of N integers, A1, A2 ,…, AN. Return maximum value of f(i, j) for all 1 ≤ i, j ≤ N.
 f(i, j) is defined as |A[i] - A[j]| + |i - j|, where |x| denotes absolute value of x.

 For example,

 A=[1, 3, -1]

 f(1, 1) = f(2, 2) = f(3, 3) = 0
 f(1, 2) = f(2, 1) = |1 - 3| + |1 - 2| = 3
 f(1, 3) = f(3, 1) = |1 - (-1)| + |1 - 3| = 4
 f(2, 3) = f(3, 2) = |3 - (-1)| + |2 - 3| = 5

 So, we return 5.
 */
public class MaximumAbsoluteDifference {

    /*
    f(i, j) = |A[i] - A[j]| + |i - j| can be written in 4 ways
    (Since we are looking at max value, we don’t even care if the value
    becomes negative as long as we are also covering the max value in some way).

    (A[i] + i) - (A[j] + j)
    -(A[i] - i) + (A[j] - j)
    (A[i] - i) - (A[j] - j)
    (-A[i] - i) + (A[j] + j) = -(A[i] + i) + (A[j] + j)
    Note that case 1 and 4 are equivalent and so are case 2 and 3.

    We can construct two arrays with values: A[i] + i and A[i] - i.
    Then, for above 2 cases, we find the maximum value possible.
    For that, we just have to store minimum and maximum values of
    expressions A[i] + i and A[i] - i for all i.
     */
    public int maxArr(List<Integer> list) {
        if (list.size() < 2) return 0;

        int res = Integer.MIN_VALUE;
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;

        for (int i = 0; i < list.size(); ++i) {
            max1 = Math.max(list.get(i) + i, max1);
            min1 = Math.min(list.get(i) + i, min1);

            max2 = Math.max(list.get(i) - i, max2);
            min2 = Math.min(list.get(i) - i, min2);
        }

        res = Math.max(max1 - min1, res);
        res = Math.max(max2 - min2, res);
        return res;
    }

    public int maxArrV1(List<Integer> list) {
        int result = -1;
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                result = Math.max(result, f(i, j, list));
            }
        }
        return result;
    }

    private int f(int i, int j, List<Integer> list) {
        return Math.abs(list.get(i) - list.get(j)) + Math.abs(i - j);
    }

    public static void main(String[] args) {
        MaximumAbsoluteDifference solution = new MaximumAbsoluteDifference();
        System.out.println(solution.maxArr(Arrays.asList(1, 3, -1)));
    }
}
