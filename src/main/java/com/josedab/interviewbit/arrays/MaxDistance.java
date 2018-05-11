package com.josedab.interviewbit.arrays;

import java.util.Arrays;
import java.util.List;

/**
 * Given an array A of integers, find the maximum of j - i subjected to the constraint of A[i] <= A[j].

 If there is no solution possible, return -1.

 Example :

 A : [3 5 4 2]

 Output : 2
 for the pair (3, 4)
 */
public class MaxDistance {

    /*
        Method 1 (Simple but Inefficient)
        Run two loops. In the outer loop, pick elements one by one from left.
        In the inner loop, compare the picked element with the elements starting from right side.
        Stop the inner loop when you see an element greater than the picked element and keep
        updating the maximum j-i so far.

        O(n) = O(n^2)
     */
    public int maximumGap(final List<Integer> list) {
        int result = 0;
        for (int i = 0; i < (list.size() - 1); i++) {
            int elemI = list.get(i);
            for (int j = i + 1; j < list.size(); j++) {
                int elemJ = list.get(j);
                if (elemJ >= elemI && (j - i) > result) {
                    result = j - i;
                }
            }
        }
        return result;
    }

    /*
        Method 2 (Efficient)
        To solve this problem, we need to get two optimum indexes of arr[]: left index i and right index j.
        For an element arr[i], we do not need to consider arr[i] for left index if there is an element smaller
        than arr[i] on left side of arr[i]. Similarly, if there is a greater element on right side of arr[j]
        then we do not need to consider this j for right index. So we construct two auxiliary arrays
        LMin[] and RMax[] such that LMin[i] holds the smallest element on left side of arr[i] including
        arr[i], and RMax[j] holds the greatest element on right side of arr[j] including arr[j].
        After constructing these two auxiliary arrays, we traverse both of these arrays from left to right.
        While traversing LMin[] and RMa[] if we see that LMin[i] is greater than RMax[j], then
        we must move ahead in LMin[] (or do i++) because all elements on left of LMin[i] are greater than
        or equal to LMin[i].
        Otherwise we must move ahead in RMax[j] to look for a greater j – i value.
     */
    public int maximumGapOfficial(final List<Integer> list) {
        int n = list.size();
        int[] min = new int[n];
        int[] max = new int[n];

        min[0] = list.get(0);
        max[n - 1] = list.get(n - 1);
        for (int i = 1; i < n; i++) {
            min[i] = Math.min(min[i - 1], list.get(i));
            max[n - i - 1] = Math.max(max[n - i], list.get(n - i - 1));
        }

        int i = 0;
        int j = 1;
        int result = 0;
        while (j < n && i < n) {
            if (min[i] <= max[j]) {
                result = Math.max(result, j - i);
                j = j + 1;
            } else
                i = i + 1;
        }
        return result;
    }

    public static void main(String[] args) {
        MaxDistance solution = new MaxDistance();
        System.out.println(solution.maximumGap(Arrays.asList(3, 5, 4, 2)));
        System.out.println(solution.maximumGap(Arrays.asList(1)));
        System.out.println(solution.maximumGapOfficial(Arrays.asList(3, 5, 4, 2)));
        System.out.println(solution.maximumGapOfficial(Arrays.asList(1)));
    }
}
