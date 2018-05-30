package com.josedab.interviewbit.twoPointers;

import java.util.Arrays;
import java.util.List;

/**
 * Remove Duplicates from Sorted Array

 Given a sorted array, remove the duplicates in place such that each element can appear
 atmost twice and return the new length.

 Do not allocate extra space for another array, you must do this in place with constant memory.

 Note that even though we want you to return the new length, make sure to change the original
 array as well in place

 For example,
 Given input array A = [1,1,1,2],

 Your function should return length = 3, and A is now [1,1,2].
 */
public class RemoveDuplicatesFromSortedArrayII {
    public int removeDuplicates(List<Integer> list) {
        int result = 0;
        if (list != null && list.size() > 0) {
            int previousElement = list.get(0);
            result++;
            int count = 1;
            int pointer = 0;
            for (int i = 1; i < list.size(); i++) {
                int element = list.get(i);
                if (previousElement == element) {
                    count++;
                } else {
                    count = 1;
                }
                if (count <= 2) {
                    pointer++;
                    result++;
                }
                list.set(pointer, element);
                previousElement = element;
            }

        }
        return result;
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArrayII solution = new RemoveDuplicatesFromSortedArrayII();
        List<Integer> problem = Arrays.asList(0, 0, 0, 1, 2, 2, 3);
        int result = solution.removeDuplicates(problem);
        System.out.println(result + " -> " + problem.subList(0, result));
    }
}
