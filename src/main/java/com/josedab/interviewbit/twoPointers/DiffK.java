package com.josedab.interviewbit.twoPointers;

import java.util.Arrays;
import java.util.List;

/**
 * Given an array ‘A’ of sorted integers and another non negative integer k,
 * find if there exists 2 indices i and j such that A[i] - A[j] = k, i != j.

 Example: Input :
 A : [1 3 5]
 k : 4
 Output : YES as 5 - 1 = 4
 Return 0 / 1 ( 0 for false, 1 for true ) for this problem

 Try doing this in less than linear space complexity.
 */
public class DiffK {

    public int diffPossible(List<Integer> list, int target) {
        int i = 0;
        int j = i + 1;
        while (j < list.size()) {
            int elemA = list.get(i);
            int elemB = list.get(j);
            int difference = elemB - elemA;
            if (difference == target) {
                return 1;
            } else if (difference < target) {
                j++;
            } else {
                i++;
                if (i == j) {
                    j++;
                }
            }

        }
        return 0;
    }

    public static void main(String[] args) {
        DiffK solution = new DiffK();
        System.out.println(solution.diffPossible(Arrays.asList(1, 3, 5), 4));
    }

}
