package com.josedab.interviewbit.binarySearch;

import java.util.Arrays;
import java.util.List;

/**
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.

 (i.e., 0 1 2 4 5 6 7  might become 4 5 6 7 0 1 2 ).

 You are given a target value to search. If found in the array, return its index, otherwise return -1.

 You may assume no duplicate exists in the array.

 Input : [4 5 6 7 0 1 2] and target = 4
 Output : 0

 NOTE : Think about the case when there are duplicates.
 Does your current solution work? How does the time complexity change?*
 */
public class RotatedSortedArraySearch {

    public int search(final List<Integer> a, int b) {

        int i = 0;
        int j = a.size() - 1;

        while (i <= j) {
            int middle = (i + j) / 2;
            int startValue = a.get(i);
            int endValue = a.get(j);
            int middleValue = a.get(middle);

            if (middleValue == b) {
                return middle;
            } else if (middleValue > startValue) {
                if (middleValue > b && startValue <= b) {
                    j = middle - 1;
                } else {
                    i = middle + 1;
                }
            } else {
                if (middleValue > b && endValue > b) {
                    j = middle - 1;
                } else {
                    i = middle + 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        RotatedSortedArraySearch solution = new RotatedSortedArraySearch();
        List<Integer> arrayToSearch = Arrays.asList(4, 5, 6, 0, 1, 2, 3, 4);
        System.out.println(solution.search(arrayToSearch, 0));
        arrayToSearch = Arrays.asList(0, 1, 2, 3, 4, 5, 6);
        System.out.println(solution.search(arrayToSearch, 4));
    }
}
