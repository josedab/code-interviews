package com.josedab.interviewbit.math;

/**
 * Reverse digits of an integer.

 Example1:

 x = 123,

 return 321
 Example2:

 x = -123,

 return -321

 Return 0 if the result overflows and does not fit in a 32 bit signed integer


 */
public class ReverseInteger {
    public int reverse(int num) {

        boolean negativeFlag = num < 0;
        num = negativeFlag ? -num : num;

        int previousResult = 0;
        int result = 0;

        while (num != 0) {
            int digit = num % 10;

            result = (result * 10) + digit;

            // Overflown checking
            if ((result - digit) / 10 != previousResult) {
                return 0;
            }

            previousResult = result;
            num = num / 10;
        }

        return (negativeFlag == true) ? -result : result;
    }

    public static void main(String[] args) {
        ReverseInteger solution = new ReverseInteger();
        System.out.println(solution.reverse(123));
        System.out.println(solution.reverse(-123));
    }
}
