package com.josedab.interviewbit.strings;

/**
 * Given a roman numeral, convert it to an integer.

 Input is guaranteed to be within the range from 1 to 3999.

 Read more details about roman numerals at Roman Numeric System

 Example :

 Input : "XIV"
 Return : 14
 Input : "XX"
 Output : 20
 */
public class RomanToInt {
    public int romanToInt(String str) {
        int result = 0;
        String letters = "MDCLXVI";
        int[] values = new int[]{1000, 500, 100, 50, 10, 5, 1};
        int previousValue = 0;

        for (int i = 0; i < str.length(); i++) {
            int indexLetter = letters.indexOf(str.charAt(i));
            int value = values[indexLetter];

            if (previousValue < value) {
                result -= (previousValue * 2);
            }
            result += value;
            previousValue = value;
        }
        return result;
    }

    public static void main(String[] args) {
        RomanToInt solution = new RomanToInt();
        System.out.println(solution.romanToInt("XIV"));
        System.out.println(solution.romanToInt("XX"));
    }
}
