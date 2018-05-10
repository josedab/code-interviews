package com.josedab.interviewbit.dynamicProgramming;

/**
 * Given a string S, find the longest palindromic substring in S.

 Substring of string S:

 S[i...j] where 0 <= i <= j < len(S)

 Palindrome string:

 A string which reads the same backwards. More formally, S is palindrome if reverse(S) = S.

 Incase of conflict, return the substring which occurs first ( with the least starting index ).

 Example :

 Input : "aaaabaaa"
 Output : "aaabaaa"

 For DP solution see {@link LongestPalindromeSubstringDp}
 */
public class LongestPalindromeSubstringDp {

    /*
      We maintain a boolean table[n][n] that is filled in bottom up manner.
      The value of table[i][j] is true, if the substring is palindrome, otherwise false.
      To calculate table[i][j], we first check the value of table[i+1][j-1],
      if the value is true and str[i] is same as str[j], then we make table[i][j] true.
      Otherwise, the value of table[i][j] is made false.

      Solution got from G4G
      https://www.geeksforgeeks.org/longest-palindrome-substring-set-1/

      Time complexity: O ( n^2 )
      Auxiliary Space: O ( n^2 )
     */
    public String longestPalindrome(String str) {

        int n = str.length();   // get length of input string

        // table[i][j] will be false if substring str[i..j]
        // is not palindrome.
        // Else table[i][j] will be true
        boolean dp[][] = new boolean[n][n];

        // All substrings of length 1 are palindromes
        int maxLength = 1;
        for (int i = 0; i < n; ++i)
            dp[i][i] = true;

        // check for sub-string of length 2.
        int start = 0;
        for (int i = 0; i < n - 1; ++i) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                dp[i][i + 1] = true;
                start = i;
                maxLength = 2;
            }
        }

        // Check for lengths greater than 2. k is length
        // of substring
        for (int k = 3; k <= n; k++) {

            // Fix the starting index
            for (int i = 0; i < n - k + 1; i++) {
                // Get the ending index of substring from
                // starting index i and length k
                int j = i + k - 1;

                // checking for sub-string from ith index to
                // jth index iff str.charAt(i+1) to
                // str.charAt(j-1) is a palindrome
                if (dp[i + 1][j - 1] && str.charAt(i) == str.charAt(j)) {
                    dp[i][j] = true;

                    if (k > maxLength) {
                        start = i;
                        maxLength = k;
                    }
                }
            }
        }

        return str.substring(start, start + maxLength); // return length of LPS
    }

    public static void main(String[] args) {
        LongestPalindromeSubstringDp solution = new LongestPalindromeSubstringDp();
        System.out.println(solution.longestPalindrome("aaaabaaa"));
    }
}
