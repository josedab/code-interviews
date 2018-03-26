package com.josedab.interviewbit.hashing;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given an array A of integers and another non negative integer k, find if there exists 2 indices i and j such that A[i] - A[j] = k, i != j.

 Example :

 Input :

 A : [1 5 3]
 k : 2
 Output :

 1
 as 3 - 1 = 2

 Return 0 / 1 for this problem.
 */
public class DiffK {

    public int diffPossible(final List<Integer> A, int B) {
        Set<Integer> set = new HashSet<Integer>(A.size());
        int result = 0;
        for (int element : A) {
            if (set.contains(B + element) || set.contains(element - B)) {
                result = 1;
                break;
            } else {
                set.add(element);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        DiffK solution = new DiffK();
        System.out.println(solution.diffPossible(Arrays.asList(1, 5, 3), 2));
    }
}
