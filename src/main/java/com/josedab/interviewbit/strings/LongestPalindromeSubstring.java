package com.josedab.interviewbit.strings;

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
 */
public class LongestPalindromeSubstring {

    /*
    The simple approach is to check each substring whether the substring is a palindrome or not.
    We can run three loops, the outer two loops pick all substrings one by one by fixing
    the corner characters, the inner loop checks whether the picked substring is palindrome or not.

    Time complexity: O ( n^3 ) => the for loops and string reverse
    Auxiliary complexity: O ( 1 )
     */
    public String longestPalindrome(String str) {

        String result = "";
        int max = 0;
        for (int i = 0; i < str.length(); i++) {

            for (int j = str.length(); j >= i; j--) {

                String subStr = str.substring(i, j);
                String reverse = new StringBuffer(subStr).reverse().toString();
                if ((j - i + 1) > max && subStr.equals(reverse)) {
                    max = j - i + 1;
                    result = subStr;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LongestPalindromeSubstring solution = new LongestPalindromeSubstring();
        System.out.println(solution.longestPalindrome("aaaabaaa"));
    }
}
