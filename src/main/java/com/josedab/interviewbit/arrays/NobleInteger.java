package com.josedab.interviewbit.arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Given an integer array, find if an integer p exists in the array such that the number of integers
   greater than p in the array equals to p

   If such an integer is found return 1 else return -1.
 */
public class NobleInteger {

    public int solve(List<Integer> list) {

        Collections.sort(list);

        // Return a Noble element if present
        // before last.
        int n = list.size();
        for (int i = 0; i < n - 1; i++) {
            if (list.get(i) == list.get(i + 1))
                continue;

            // In case of duplicates, we
            // reach last occurrence here.
            if (list.get(i) == n - i - 1)
                return 1;
        }

        if (list.get(n - 1) == 0)
            return 1;

        return -1;
    }

    // Variant where the result is the noble integer
    public int solveV2(List<Integer> list) {

        Collections.sort(list);

        int n = list.size();
        for (int i = 0; i < n - 1; i++) {
            if (list.get(i) == list.get(i + 1))
                continue;

            if (list.get(i) == n - i - 1)
                return list.get(i);
        }

        if (list.get(n - 1) == 0)
            return list.get(n - 1);

        return -1;
    }

    public static void main(String[] args) {
        NobleInteger solution = new NobleInteger();
        List<Integer> problem = Arrays.asList(10, 3, 20, 40, 2);
        System.out.println(solution.solve(problem));
        System.out.println(solution.solveV2(problem));
    }
}
