package com.josedab.interviewbit.dynamicProgramming;

/**
 * Find out the number of N digit numbers, whose digits on being added equals to a given number S. Note that a valid number starts from digits 1-9 except the number 0 itself. i.e. leading zeroes are not allowed.

 Since the answer can be large, output answer modulo 1000000007

 **

 N = 2, S = 4
 Valid numbers are {22, 31, 13, 40}
 Hence output 4.

 Solution: Dp
 Pros: Can count the solutions without the result being O(2^n)
 Cons: Cannot give the solutions, just the count. For giving up the solution, backtracking
 is necessary and it is done on {@link NDigitNumbersWithDigitSumSBacktracking}
 */
public class NDigitNumbersWithDigitSum {

    public int solve(int nDigits, int sum) {

        if (sum > 9 * nDigits)
            return 0;
        if (sum == 9 * nDigits)
            return 1;
        int mod = 1000000007;

        long[][] dp = new long[nDigits + 1][sum + 1];
        for (int j = 1; j <= Math.min(sum, 9); j++) {
            dp[1][j] = 1;
        }
        for (int i = 2; i <= nDigits; i++) {
            for (int j = 1; j <= sum; j++) {
                for (int k = 0; k <= Math.min(9, j); k++) {
                    dp[i][j] += dp[i - 1][j - k];
                    dp[i][j] = dp[i][j] % mod;
                }
            }
        }
        return (int) dp[nDigits][sum];
    }

    public static void main(String[] args) {
        NDigitNumbersWithDigitSum solution = new NDigitNumbersWithDigitSum();
        System.out.println(solution.solve(2, 4));
    }

}
