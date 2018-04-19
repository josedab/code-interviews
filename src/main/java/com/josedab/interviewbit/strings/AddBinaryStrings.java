package com.josedab.interviewbit.strings;

/**
 * Given two binary strings, return their sum (also a binary string).

 Example:

 a = "100"

 b = "11"
 Return a + b = “111”.
 */
public class AddBinaryStrings {

    public String addBinary(String A, String B) {
        StringBuilder result = new StringBuilder();
        A = new StringBuilder(A).reverse().toString();
        B = new StringBuilder(B).reverse().toString();

        int minSize = Math.min(A.length(), B.length());
        int carryOver = 0;
        for (int i = 0; i < minSize; i++) {
            int sum = convertCharToInteger(A.charAt(i)) + convertCharToInteger(B.charAt(i)) + carryOver;
            carryOver = sum / 2;
            int digit = sum % 2;
            result.append(digit);
        }

        String str = A;
        if (B.length() != A.length()) {
            if (B.length() > A.length()) {
                str = B;
            }

            for (int i = minSize; i < str.length(); i++) {
                int sum = convertCharToInteger(str.charAt(i)) + carryOver;
                carryOver = sum / 2;
                int digit = sum % 2;
                result.append(digit);
            }

        }

        if (carryOver > 0) {
            result.append(carryOver);
        }

        return result.reverse().toString();
    }

    private int convertCharToInteger(char c){
        return c - '0';
    }

    public static void main(String[] args) {
        AddBinaryStrings solution = new AddBinaryStrings();
        System.out.println(solution.addBinary("100", "11"));
    }
}
