package com.josedab.interviewbit.arrays;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://www.interviewbit.com/problems/find-duplicate-in-array/
 *
 * Given a read only array of n + 1 integers between 1 and n, find one number that repeats in linear time using less than O(n) space and traversing the stream sequentially O(1) times.
 *
 * Sample Input:
 * [3 4 1 4 1]
 *
 * Sample Output:
 * 1
 *
 * If there are multiple possible answers ( like in the sample case above ), output any one.
 * If there is no duplicate, output -1
 */
public class FindDuplicateInArray {
    public int repeatedNumber(final List<Integer> a) {
        Set<Integer> numbers = new HashSet<Integer>();
        int result = -1;
        for (int i = 0; i < a.size(); i++) {
            int element = a.get(i);
            if (numbers.contains(element)) {
                result = element;
                break;
            } else {
                numbers.add(element);
            }
        }
        return result;
    }
}
