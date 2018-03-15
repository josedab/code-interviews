package com.josedab.interviewbit.binarySearch;

import java.util.Arrays;
import java.util.List;

/**
 * Given a sorted array of integers, find the number of occurrences of a given target value.
 Your algorithm’s runtime complexity must be in the order of O(log n).
 If the target is not found in the array, return 0

 **Example : **
 Given [5, 7, 7, 8, 8, 10] and target value 8,
 return 2.
 */
public class CountElementOcurrence {
    public int findCount(final List<Integer> A, int B) {
        int firstIndex = binarySearch(A, B, true);
        int lastIndex = binarySearch(A, B, false);
        if (lastIndex == -1) {
            return 0;
        }
        return lastIndex - firstIndex + 1;
    }

    private int binarySearch(final List<Integer> A, int elem, boolean searchFirst) {
        int result = -1;
        int start = 0, end = A.size() - 1;
        while (start <= end) {
            int middle = (start + end) / 2;
            if (A.get(middle).equals(elem)) {
                result = middle;
                if (searchFirst) {
                    end = middle - 1;
                } else {
                    start = middle + 1;
                }

            } else if (A.get(middle) < elem) {
                start = middle + 1;
            } else {
                end = middle - 1;

            }
        }
        return result;
    }

    public static void main(String[] args) {
        CountElementOcurrence solution = new CountElementOcurrence();

        List<Integer> array1 = Arrays.asList(1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 4, 9, 9, 10, 10, 10);
        System.out.println("Array 1: " + solution.findCount(array1, 1));

        List<Integer> array2 = Arrays.asList(5, 7, 7, 8, 8, 10);
        System.out.println("Array 2: " + solution.findCount(array2, 1));

    }

}
