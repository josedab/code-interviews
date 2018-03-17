package com.josedab.interviewbit.twoPointers;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target.
 Return the sum of the three integers.

 Assume that there will only be one solution

 Example:
 given array S = {-1 2 1 -4},
 and target = 1.

 The sum that is closest to the target is 2. (-1 + 2 + 1 = 2)
 */
public class ThreeSum {
    public int threeSumClosest(List<Integer> array, int target) {
        Collections.sort(array);
        int i = 0;
        int k = 1;
        int j = array.size() - 1;
        int solution = Integer.MIN_VALUE;
        while (i < j && k < j) {
            int iValue = array.get(i);
            int jValue = array.get(j);
            int kValue = array.get(k);
            //System.out.println("Evaluation: [" + i + ", " + k + ", " + j + "]");
            int sum = iValue + jValue + kValue;
            if (sum == target) {
                return sum;
            } else if (sum > target) {
                j--;
            } else {
                if (k < (j - 1)) {
                    k++;
                } else {
                    i++;
                    k = i + 1;
                }
            }
            solution = (Math.abs(sum - target) < Math.abs(solution - target)) ? sum : solution;
        }
        return solution;
    }

    public int threeSumClosestOfficialVersion(List<Integer> A, int B) {
        int low, high, mid;
        Collections.sort(A);
        int n = A.size();
        int res = A.get(0) + A.get(1) + A.get(2);

        if (n == 3) {
            return res;
        }

        int sum;

        for (low = 0; low < n - 2; low++) {
            mid = low + 1;
            high = n - 1;
            int num = B - A.get(low);

            while (mid < high) {

                sum = A.get(mid) + A.get(high);

                if (sum == num)
                    return B;
                else if (sum < num) {
                    mid++;
                } else {
                    high--;
                }

                int diff = Math.abs(sum - num);
                int otherDiff = Math.abs(res - B);

                if (diff < otherDiff)
                    res = sum + A.get(low);

            }
        }
        return res;
    }

    public static void main(String[] args) {
        ThreeSum solution = new ThreeSum();
        System.out.println(solution.threeSumClosest(Arrays.asList(2, 1, -9, -7, -8, 2, -8, 2, 3, -8), -1));
        System.out.println(solution.threeSumClosestOfficialVersion(Arrays.asList(2, 1, -9, -7, -8, 2, -8, 2, 3, -8), -1));

    }
}
