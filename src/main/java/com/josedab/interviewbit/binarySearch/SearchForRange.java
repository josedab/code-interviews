package com.josedab.interviewbit.binarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a sorted array of integers, find the starting and ending position of a given target value.

 Your algorithm’s runtime complexity must be in the order of O(log n).

 If the target is not found in the array, return [-1, -1].

 Example:

 Given [5, 7, 7, 8, 8, 10]

 and target value 8,

 return [3, 4].


 Notes:
 The solution is based on three steps:
 1. Detect if element exists and position into an index that has the target
 2. Log n search on the left side
 3. Log n search on the right side

 The solution is O(n) = 1/2 * log n + log n + 1/2 log n = 2 log n => log n
 There is an alternative solution {@link SearchForRangeAlternative} where you search for the lowerBound element
 and the higher bound element resulting on 2 log n => log n
 */
public class SearchForRange {

    public List<Integer> searchRange(final List<Integer> list, int target) {
        List<Integer> result = new ArrayList<>();
        int left = -1;
        int right = -1;

        int start = 0;
        int end = list.size() - 1;

        while (start <= end) {
            int middle = (start + end) / 2;
            int element = list.get(middle);
            if (element == target) {
                left = middle;
                right = middle;
                break;
            } else if (element > target) {
                end = middle - 1;
            } else {
                start = middle + 1;
            }
        }

        // Element has been found
        if (left != -1 && right != -1) {

            int previousLeft = -1;

            // Get most left index
            while (previousLeft != left) {

                start = 0;
                end = left - 1;
                previousLeft = left;
                while (start <= end) {
                    int middle = (start + end) / 2;
                    int element = list.get(middle);
                    if (element == target) {
                        left = middle;
                        break;
                    } else if (element > target) {
                        end = middle - 1;
                    } else {
                        start = middle + 1;
                    }
                }
            }

            int previousRight = -1;

            // Get most right index
            while (previousRight != right) {

                start = right + 1;
                end = list.size() - 1;
                previousRight = right;
                while (start <= end) {
                    int middle = (start + end) / 2;
                    int element = list.get(middle);
                    if (element == target) {
                        right = middle;
                        break;
                    } else if (element > target) {
                        end = middle - 1;
                    } else {
                        start = middle + 1;
                    }
                }
            }

        }

        result.add(left);
        result.add(right);

        return result;
    }

    public static void main(String[] args) {
        SearchForRange solution = new SearchForRange();
        List<Integer> problem = Arrays.asList(5, 7, 7, 8, 8, 10);
        int target = 8;
        System.out.println(solution.searchRange(problem, target));
    }
}
