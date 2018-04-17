package com.josedab.interviewbit.math;

/**
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.
 * For example:
 * 1 -> A
 * 2 -> B
 * 3 -> C
 * ...
 * 26 -> Z
 * 27 -> AA
 * 28 -> AB
 */
public class ExcelColumnTitle {
    public String convertToTitle(int a) {
        int num = a;
        StringBuffer buf = new StringBuffer();
        while (num > 0) {
            num--;
            char c = (char) ('A' + (num % 26));
            num = num / 26;
            buf.append(c);
        }
        return buf.reverse().toString();
    }

    public String convertToTitleV2(int num) {
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            int offset = (num % 26);
            Character c = (char) ('A' + offset - 1);
            if (offset == 0) {
                c = 'Z';
                num--;
            }
            sb.append(c);
            num = num / 26;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        ExcelColumnTitle solution = new ExcelColumnTitle();
        System.out.println(solution.convertToTitle(27));
        System.out.println(solution.convertToTitle(943566));

        System.out.println(solution.convertToTitleV2(676));
        System.out.println(solution.convertToTitleV2(702));
    }
}
