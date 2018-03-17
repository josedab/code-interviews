package com.josedab.interviewbit.twoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Find the intersection of two sorted arrays.
 OR in other words,
 Given 2 sorted arrays, find all the elements which occur in both the arrays.

 Example :

 Input :
 A : [1 2 3 3 4 5 6]
 B : [3 3 5]

 Output : [3 3 5]

 Input :
 A : [1 2 3 3 4 5 6]
 B : [3 5]

 Output : [3 5]
 NOTE : For the purpose of this problem ( as also conveyed by the sample case ), assume that
 elements that appear more than once in both arrays should be included multiple
 times in the final output.
 */
public class IntersectionOfSortedArrays {

    public List<Integer> intersect(final List<Integer> l1, final List<Integer> l2) {

        ArrayList<Integer> result = new ArrayList<Integer>();
        int i = 0;
        int j = 0;

        while (i < l1.size() && j < l2.size()) {
            int elem1 = l1.get(i);
            int elem2 = l2.get(j);

            if (elem1 == elem2) {
                result.add(elem1);
                i++;
                j++;
            } else if (elem1 > elem2) {
                j++;
            } else {
                i++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        IntersectionOfSortedArrays solution = new IntersectionOfSortedArrays();
        System.out.println(solution.intersect(Arrays.asList(1, 2, 3), Arrays.asList(2, 3, 4)));
    }

}
