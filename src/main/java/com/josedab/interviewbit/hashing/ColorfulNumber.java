package com.josedab.interviewbit.hashing;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * For Given Number N find if its COLORFUL number or not

 Return 0/1

 COLORFUL number:

 A number can be broken into different contiguous sub-subsequence parts.
 Suppose, a number 3245 can be broken into parts like 3 2 4 5 32 24 45 324 245 3245.
 And this number is a COLORFUL number, since product of every digit of a contiguous subsequence is different
 Example:

 N = 23
 2 3 23
 2 -> 2
 3 -> 3
 23 -> 6
 this number is a COLORFUL number since product of every digit of a sub-sequence are different.

 Output : 1

 */
public class ColorfulNumber {
    public int colorful(int A) {
        int result = 1;
        Stack<String> combinations = new Stack<String>();
        Set<Integer> products = new HashSet<Integer>();
        String number = String.valueOf(A);
        for (int ngram = 1; ngram <= number.length(); ngram++) {
            for (int i = 0; i <= (number.length() - ngram); i++) {
                String combination = number.substring(i, i + ngram);
                combinations.push(combination);
            }
        }

        while (!combinations.isEmpty()) {
            String combination = combinations.pop();
            Integer valueOfCombination = getValueForCombination(combination);
            if (products.contains(valueOfCombination)) {
                result = 0;
                break;
            } else {
                products.add(valueOfCombination);
            }
        }

        return result;
    }

    private Integer getValueForCombination(String combination) {
        int result = 1;
        for (int i = 0; i < combination.length(); i++) {
            int digit = Integer.valueOf(String.valueOf(combination.charAt(i)));
            result *= digit;
        }
        return result;
    }

    public static void main(String[] args) {
        ColorfulNumber solution = new ColorfulNumber();
        System.out.println(solution.colorful(23));
    }
}
