package com.josedab.interviewbit.strings;

/**
 * Given two numbers represented as strings, return multiplication of the numbers as a string.

 Note: The numbers can be arbitrarily large and are non-negative.
 Note2: Your answer should not have leading zeroes. For example, 00 is not a valid answer.
 For example,
 given strings "12", "10", your answer should be “120”.
 Note3: Avoid use of BigInteger
 */
public class MultiplyStrings {

    public String multiply(String num1, String num2) {
        String number1 = new StringBuilder(num1).reverse().toString();
        String number2 = new StringBuilder(num2).reverse().toString();

        int[] digits = new int[num1.length() + num2.length()];

        //multiply each digit and sum at the corresponding positions
        for (int i = 0; i < number1.length(); i++) {
            for (int j = 0; j < number2.length(); j++) {
                digits[i + j] += (number1.charAt(i) - '0') * (number2.charAt(j) - '0');
            }
        }

        StringBuilder sb = new StringBuilder();

        //calculate each digit
        for (int i = 0; i < digits.length; i++) {
            int mod = digits[i] % 10;
            int carry = digits[i] / 10;
            if (i + 1 < digits.length) {
                digits[i + 1] += carry;
            }
            sb.insert(0, mod);
        }

        //remove front 0's
        while (sb.charAt(0) == '0' && sb.length() > 1) {
            sb.deleteCharAt(0);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        MultiplyStrings solution = new MultiplyStrings();
        System.out.println(solution.multiply("12", "10"));
    }
}
