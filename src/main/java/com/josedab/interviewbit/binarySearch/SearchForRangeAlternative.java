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

 Official solution from InterviewBit
 Alternative solution : {@link SearchForRange}
 */
public class SearchForRangeAlternative {

    public ArrayList<Integer> searchRange(final List<Integer> A, int B) {

        int low, up;
        ArrayList<Integer> res = new ArrayList<>();

        low = lowerBound(A, 0, A.size() - 1, B);

        if (low == -1) {
            res.add(-1);
            res.add(-1);
            return res;
        }

        up = upperBound(A, 0, A.size() - 1, B);

        res.add(low);
        res.add(up);

        return res;


    }

    private int lowerBound(final List<Integer> A, int start, int end, int num) {

        int steps = end - start + 1;
        int mid;
        int low = -1;
        int val;

        while (steps > 0) {

            mid = (start + end) / 2;
            val = A.get(mid);

            if (num < val) {
                end = mid - 1;
            } else if (num > val) {
                start = mid + 1;
            } else {
                low = mid;
                end = mid - 1;
            }

            steps /= 2;
        }

        return low;

    }

    public int upperBound(final List<Integer> A, int start, int end, int num) {

        int steps = end - start + 1;
        int mid;
        int up = end + 1;
        int val;

        while (steps > 0) {

            mid = (start + end) / 2;
            val = A.get(mid);

            if (num < val) {
                end = mid - 1;
            } else if (num > val) {
                start = mid + 1;
            } else {
                up = mid;
                start = mid + 1;
            }

            steps /= 2;
        }

        return up;

    }

    public static void main(String[] args) {
        SearchForRangeAlternative solution = new SearchForRangeAlternative();
        List<Integer> problem = Arrays.asList(5, 7, 7, 8, 8, 10);
        int target = 8;
        System.out.println(solution.searchRange(problem, target));
    }
}
