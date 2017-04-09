package com.josedab.interviewbit.math;

/**
 * https://www.interviewbit.com/problems/grid-unique-paths/
 *
 * A robot is located at the top-left corner of an A x B grid (marked ‘Start’ in the diagram below).
 *
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked ‘Finish’ in the diagram below).
 *
 * How many possible unique paths are there?
 *
 * Note: A and B will be such that the resulting answer fits in a 32 bit signed integer.
 */
public class GridUniquePaths {
    public int uniquePaths(int A, int B) {

        int res = result(A, B);

        return res;
    }

    public int result(int m, int n) {

        int res = 1;
        int num = m + n - 2;
        m--;
        n--;

        if (m == 0 || n == 0)
            return 1;

        int max = Math.max(m, n);
        int val = 1;

        for (int i = max + 1; i <= num; i++) {
            res *= i;
            res /= val;
            val++;
        }

        return res;

    }

    public static void main(String[] args) {
        GridUniquePaths uniquePaths = new GridUniquePaths();
        System.out.println(uniquePaths.uniquePaths(2, 2));
        System.out.println(uniquePaths.uniquePaths(100, 1));
    }
}
