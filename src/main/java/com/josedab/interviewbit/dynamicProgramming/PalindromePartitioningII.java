package com.josedab.interviewbit.dynamicProgramming;

/**
 * Given a string s, partition s such that every substring of the partition is a palindrome.

 Return the minimum cuts needed for a palindrome partitioning of s.

 Example :
 Given
 s = "aab",
 Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.


 */
public class PalindromePartitioningII {

    public int minCut(String str) {
        int[] dp = new int[str.length()];
        boolean[][] palindrome = new boolean[str.length()][str.length()];

        for (int j = 0; j < str.length(); j++) {
            int minCut = j;
            for (int i = 0; i <= j; i++) {
                if (str.charAt(j) == str.charAt(i) &&
                        (j - i < 2 || palindrome[i + 1][j - 1])) {
                    palindrome[i][j] = true;
                    minCut = Math.min(minCut, i == 0 ? 0 : (dp[i - 1] + 1));
                }
            }
            dp[j] = minCut;
        }

        return dp[str.length() - 1];
    }

    public static void main(String[] args) {
        PalindromePartitioningII solution = new PalindromePartitioningII();
        System.out.println(solution.minCut("abcba"));
        System.out.println(solution.minCut("aab"));
    }
}
