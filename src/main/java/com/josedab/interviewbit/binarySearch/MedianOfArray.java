package com.josedab.interviewbit.binarySearch;

import java.util.Arrays;
import java.util.List;

/**
 * There are two sorted arrays A and B of size m and n respectively.
 *
 Find the median of the two sorted arrays ( The median of the array formed by merging both the arrays ).

 The overall run time complexity should be O(log (m+n)).

 Sample Input

 A : [1 4 5]
 B : [2 3]

 Sample Output
 3

 NOTE: IF the number of elements in the merged array is even, then the median is
 the average of n / 2 th and n/2 + 1th element.
 For example, if the array is [1 2 3 4], the median is (2 + 3) / 2.0 = 2.5

 */
public class MedianOfArray {

    public int findMedianSortedArrays(final List<Integer> nums1, final List<Integer> nums2) {
        int total = nums1.size() + nums2.size();
        if (total % 2 == 0) {
            return (findNth(total / 2, nums1, nums2, 0, 0) + findNth(total / 2 + 1, nums1, nums2, 0, 0)) / 2;
        } else {
            return findNth(total / 2 + 1, nums1, nums2, 0, 0);
        }
    }

    public int findNth(int k, List<Integer> nums1, List<Integer> nums2, int s1, int s2) {
        if (s1 >= nums1.size())
            return nums2.get(s2 + k - 1);

        if (s2 >= nums2.size())
            return nums1.get(s1 + k - 1);

        if (k == 1)
            return Math.min(nums1.get(s1), nums2.get(s2));

        int m1 = s1 + k / 2 - 1;
        int m2 = s2 + k / 2 - 1;

        int mid1 = m1 < nums1.size() ? nums1.get(m1) : Integer.MAX_VALUE;
        int mid2 = m2 < nums2.size() ? nums2.get(m2) : Integer.MAX_VALUE;

        if (mid1 < mid2) {
            return findNth(k - k / 2, nums1, nums2, m1 + 1, s2);
        } else {
            return findNth(k - k / 2, nums1, nums2, s1, m2 + 1);
        }
    }

    public static void main(String[] args) {
        MedianOfArray solution = new MedianOfArray();
        List<Integer> nums1 = Arrays.asList(1, 4, 5);
        List<Integer> nums2 = Arrays.asList(2, 3);
        System.out.println(solution.findMedianSortedArrays(nums1, nums2));
    }
}
