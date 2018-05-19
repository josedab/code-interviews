package com.josedab.interviewbit.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a non-negative number represented as an array of digits,

 add 1 to the number ( increment the number represented by the digits ).

 The digits are stored such that the most significant digit is at the head of the list.

 Example:

 If the vector has [1, 2, 3]

 the returned vector should be [1, 2, 4]

 as 123 + 1 = 124.

 NOTE: Certain things are intentionally left unclear in this question which you should practice asking the interviewer.
 For example, for this problem, following are some good questions to ask :
 Q : Can the input have 0’s before the most significant digit. Or in other words, is 0 1 2 3 a valid input?
 A : For the purpose of this question, YES
 Q : Can the output have 0’s before the most significant digit? Or in other words, is 0 1 2 4 a valid output?
 A : For the purpose of this question, NO. Even if the input has zeroes before the most significant digit.
 */
public class AddOneToNumber {

    // O(n) = 2n = n
    public List<Integer> plusOne(List<Integer> list) {
        List<Integer> result = new ArrayList<>();
        int carryOver = 1;

        int start = 0;
        while (list.get(start) == 0 && start < (list.size() - 1)) start++;
        for (int i = (list.size() - 1); i >= start; i--) {
            int digit = list.get(i);
            int num = digit + carryOver;
            result.add(num % 10);
            carryOver = num / 10;
        }
        if (carryOver > 0) {
            result.add(carryOver);
        }

        // Reverse list
        for (int i = 0; i < (result.size() / 2); i++) {
            int temp = result.get(i);
            int j = result.size() - 1 - i;
            result.set(i, result.get(j));
            result.set(j, temp);
        }

        return result;
    }

    // Variation where there is not a reverse, just an initialization and sum over the elements of the array
    // O(n) = 2n = n
    public List<Integer> plusOneAlternative(List<Integer> list) {
        List<Integer> result = new ArrayList<>();

        int carryOver = 1;

        int start = 0;
        while (list.get(start) == 0 && start < (list.size() - 1)) start++;

        // Initialization of the array
        for (int i = start; i < list.size(); i++) {
            result.add(0);
        }

        for (int i = (list.size() - 1); i >= start; i--) {
            int digit = list.get(i);
            int num = digit + carryOver;
            result.set(i - start, (num % 10));
            carryOver = num / 10;
        }
        if (carryOver > 0) {
            result.add(0, carryOver);
        }

        return result;
    }

    public static void main(String[] args) {
        AddOneToNumber solution = new AddOneToNumber();
        System.out.println(solution.plusOne(Arrays.asList(1, 2, 3)));
        System.out.println(solution.plusOne(Arrays.asList(0)));
        System.out.println(solution.plusOneAlternative(Arrays.asList(1, 2, 3)));
        System.out.println(solution.plusOneAlternative(Arrays.asList(0)));
    }

}
