package com.josedab.interviewbit.arrays;

import java.util.Arrays;
import java.util.List;

/**
 * You’re given a read only array of n integers.
 * Find out if any integer occurs more than n/3 times in the array in linear time
 * and constant additional space.

 If so, return the integer. If not, return -1.

 If there are multiple solutions, return any one.

 Example :

 Input : [1 2 3 1 1]
 Output : 1
 1 occurs 3 times which is more than 5/3 times.

 https://www.interviewbit.com/problems/n3-repeat-number/
 Solution: https://www.geeksforgeeks.org/n3-repeated-number-array-o1-space/

 Solution approach:

 It is important to note that if at a given time, you have 3 distinct element from the array, if you remove them from
 the array, your answer does not change.

 Assume that we maintain 2 elements with their counts as we traverse along the array.

 When we encounter a new element, there are 3 cases possible :

 We don’t have 2 elements yet. So add this to the list with count as 1.

 This element is different from the existing 2 elements. As we said before, we have 3 distinct numbers now.
 Removing them does not change the answer. So decrement 1 from count of 2 existing elements.
 If their count falls to 0, obviously its not a part of 2 elements anymore.

 The new element is same as one of the 2 elements. Increment the count of that element.

 Consequently, the answer will be one of the 2 elements left behind. If they are not the answer,
 then there is no element with count > N / 3.
 */
public class TripleRepeatNumber {

    public int repeatedNumber(final List<Integer> arr) {

        int count1 = 0, count2 = 0;
        int n = arr.size();

        // take the integers as the maximum
        // value of integer hoping the integer
        // would not be present in the array
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {

            int element = arr.get(i);
            // if this element is previously
            // seen, increment count1.
            if (first == element)
                count1++;

                // if this element is previously
                // seen, increment count2.
            else if (second == element)
                count2++;

            else if (count1 == 0) {
                count1++;
                first = element;
            } else if (count2 == 0) {
                count2++;
                second = element;
            }

            // if current element is different
            // from both the previously seen
            // variables, decrement both the
            // counts.
            else {
                count1--;
                count2--;
            }
        }

        count1 = 0;
        count2 = 0;

        // Again traverse the array and
        // find the actual counts.
        for (int i = 0; i < n; i++) {
            if (arr.get(i) == first)
                count1++;

            else if (arr.get(i) == second)
                count2++;
        }

        if (count1 > (n / 3.0f))
            return first;

        if (count2 > (n / 3.0f))
            return second;

        return -1;
    }

    public static void main(String[] args) {
        TripleRepeatNumber solution = new TripleRepeatNumber();

        List<Integer> problem = Arrays.asList(1);
        System.out.println(solution.repeatedNumber(problem));

        problem = Arrays.asList(1, 2, 3, 1, 1);
        System.out.println(solution.repeatedNumber(problem));
    }


}
