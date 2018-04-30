package com.josedab.interviewbit.stacksAndQueues;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * A long array A[] is given to you. There is a sliding window of size w which is moving from
 * the very left of the array to the very right. You can only see the w numbers in the window.
 * Each time the sliding window moves rightwards by one position. You have to find the maximum
 * for each window. The following example will give you more clarity.

 Example :

 The array is [1 3 -1 -3 5 3 6 7], and w is 3.

 Window position	Max

 [1 3 -1] -3 5 3 6 7	3
 1 [3 -1 -3] 5 3 6 7	3
 1 3 [-1 -3 5] 3 6 7	5
 1 3 -1 [-3 5 3] 6 7	5
 1 3 -1 -3 [5 3 6] 7	6
 1 3 -1 -3 5 [3 6 7]	7
 Input: A long array A[], and a window width w
 Output: An array B[], B[i] is the maximum value of from A[i] to A[i+w-1]
 Requirement: Find a good optimal way to get B[i]

 Note: If w > length of the array, return 1 element with the max of the array.

 Solution: for official solution see {@link SlidingWindowMaximumOfficial}
 */
public class SlidingWindowMaximum {

    public ArrayList<Integer> slidingMaximum(final List<Integer> list, int windowSize) {
        Deque<Integer> queue = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < list.size(); i++) {
            Integer element = list.get(i);
            max = Math.max(max, element);
            queue.add(element);

            if (queue.size() == windowSize) {
                result.add(max);
                Integer poppedElement = queue.remove();
                if (poppedElement == max) {
                    max = recalculateMax(queue);
                }
            }
        }
        return result;

    }

    private int recalculateMax(Deque<Integer> queue) {
        int max = Integer.MIN_VALUE;
        for (int element : queue) {
            max = Math.max(element, max);
        }
        return max;
    }

    public static void main(String[] args) {
        SlidingWindowMaximum solution = new SlidingWindowMaximum();
        System.out.println(solution.slidingMaximum(Arrays.asList(1, 3, -1, -3, 5, 3, 6, 7), 3));
        System.out.println(solution.slidingMaximum(Arrays.asList(1), 1));
        System.out.println(solution.slidingMaximum(Arrays.asList(10, 9, 8, 7, 6, 5, 4, 3, 2, 1), 1));

    }

}
