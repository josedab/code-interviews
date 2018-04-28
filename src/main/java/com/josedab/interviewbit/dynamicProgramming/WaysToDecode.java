package com.josedab.interviewbit.dynamicProgramming;

/**
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:

 'A' -> 1
 'B' -> 2
 ...
 'Z' -> 26
 Given an encoded message containing digits, determine the total number of ways to decode it.

 Example :

 Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

 The number of ways decoding "12" is 2.


 */
public class WaysToDecode {

    private static final char ZERO = '0';

    public int numDecodings(String str) {
        if (str == null || str.length() == 0 || str.charAt(0) == ZERO)
            return 0;

        if (str.length() == 1)
            return 1;

        int[] dp = new int[str.length()];
        dp[0] = 1;

        if (Integer.parseInt(str.substring(0, 2)) > 26) {
            if (str.charAt(1) != '0') {
                dp[1] = 1;
            } else {
                dp[1] = 0;
            }
        } else {
            if (str.charAt(1) != '0') {
                dp[1] = 2;
            } else {
                dp[1] = 1;
            }
        }

        for (int i = 2; i < str.length(); i++) {
            if (str.charAt(i) != '0') {
                dp[i] += dp[i - 1];
            }

            int val = Integer.parseInt(str.substring(i - 1, i + 1));
            if (val <= 26 && val >= 10) {
                dp[i] += dp[i - 2];
            }
        }

        return dp[str.length() - 1];

    }

    public static void main(String[] args) {
        WaysToDecode solution = new WaysToDecode();
        System.out.println(solution.numDecodings("12"));
        System.out.println(solution.numDecodings("0"));
        System.out.println(solution.numDecodings("90"));
        System.out.println(solution.numDecodings("912"));
    }
}
