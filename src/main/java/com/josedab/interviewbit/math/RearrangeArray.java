package com.josedab.interviewbit.math;

import java.util.ArrayList;

/**
 * https://www.interviewbit.com/problems/rearrange-array/
 *
 * Rearrange a given array so that Arr[i] becomes Arr[Arr[i]] with O(1) extra space.
 *
 * Example:
 * Input : [1, 0]
 * Return : [0, 1]
 *
 * Lets say N = size of the array. Then, following holds true :
 * All elements in the array are in the range [0, N-1]
 * N * N does not overflow for a signed integer
 */
public class RearrangeArray {

    public void arrange(ArrayList<Integer> a) {

        /**
         * Main idea is using factorization to hold several values
         * A*B + C
         * Knowing that N is the module, we could retrieve A and C without extra memory
         */
        for (int i = 0; i < a.size(); i++) {
            a.set(i, (a.get(a.get(i)) % a.size()) * a.size() + a.get(i));
        }

        for (int i = 0; i < a.size(); i++) {
            a.set(i, a.get(i) / a.size());
        }
    }

}
