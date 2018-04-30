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


 Approach:
 The double-ended queue is the perfect data structure for this problem.
 It supports insertion/deletion from the front and back.
 The trick is to find a way such that the largest element in the window
 would always appear in the front of the queue.
 How would you maintain this requirement as you push and pop elements in and out of the queue?

 You might notice that there are some redundant elements in the
 queue that we should not even consider about.
 For example, if the current queue has the elements: [10 5 3],
 and a new element in the window has the element 11.
 Now, we could have emptied the queue without considering elements 10, 5, and 3,
 and insert only element 11 into the queue.

 A natural way most people would think is to try to maintain the queue
 size the same as the window’s size. Try to break away from this
 thought and try to think outside of the box. Removing redundant
 elements and storing only elements that need to be considered in the queue
 is the key to achieve the efficient O(n) solution.
 */
public class SlidingWindowMaximumOfficial {

    public ArrayList<Integer> slidingMaximum(final List<Integer> list, int windowSize) {
        ArrayList<Integer> result = new ArrayList<>();
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < list.size(); i++) {
            while (!queue.isEmpty() && (queue.peekFirst() + windowSize <= i
                    || list.get(queue.peekFirst()) <= list.get(i))) {
                queue.pollFirst();
            }
            while (!queue.isEmpty() && (queue.peekLast() + windowSize <= i
                    || list.get(queue.peekLast()) <= list.get(i))) {
                queue.pollLast();
            }
            queue.addLast(i);
            if (i >= windowSize - 1) {
                result.add(list.get(queue.peekFirst()));
            }

        }
        return result;

    }

    public static void main(String[] args) {
        SlidingWindowMaximumOfficial solution = new SlidingWindowMaximumOfficial();
        System.out.println(solution.slidingMaximum(Arrays.asList(1, 3, -1, -3, 5, 3, 6, 7), 3));
        System.out.println(solution.slidingMaximum(Arrays.asList(1), 1));
        System.out.println(solution.slidingMaximum(Arrays.asList(10, 9, 8, 7, 6, 5, 4, 3, 2, 1), 1));

    }

}
