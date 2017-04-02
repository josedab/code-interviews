package com.josedab.interviewbit.math;

/**
 * Given a column title as appears in an Excel sheet, return its corresponding column number.
 * Example:
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28
 */
public class ExcelColumnNumber {

    public int titleToNumber(String a) {
        int result = 0;
        for (int i = a.length() - 1; i >= 0; i--) {
            int c = a.charAt(i) - 'A' + 1;
            result += (c * Math.pow(26, ((a.length() - 1) - i)));
        }
        return result;

    }

    public static void main(String[] args) {
        ExcelColumnNumber solution = new ExcelColumnNumber();
        System.out.println(solution.titleToNumber("A"));
        System.out.println(solution.titleToNumber("AA"));
    }
}
