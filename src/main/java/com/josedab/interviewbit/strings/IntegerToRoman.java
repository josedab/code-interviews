package com.josedab.interviewbit.strings;

/**
 * Given an integer, convert it to a roman numeral, and return a string corresponding to its roman numeral version

 Input is guaranteed to be within the range from 1 to 3999.

 Example :

 Input : 5
 Return : "V"

 Input : 14
 Return : "XIV"
 Note : This question has a lot of scope of clarification from the interviewer.
 Please take a moment to think of all the needed clarifications and see the expected response using
 “See Expected Output” For the purpose of this question,
 https://projecteuler.net/about=roman_numerals has very detailed explanations.
 */
public class IntegerToRoman {

    public String intToRoman(int n) {
        StringBuilder result = new StringBuilder();

        String[] letters = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] values = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

        int i = 0;
        while (i < values.length) {
            if (values[i] <= n) {
                result.append(letters[i]);
                n = n - values[i];
            } else {
                i++;
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        IntegerToRoman solution = new IntegerToRoman();
        System.out.println(solution.intToRoman(14));
    }

}
