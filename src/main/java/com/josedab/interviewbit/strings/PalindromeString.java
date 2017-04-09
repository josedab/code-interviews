package com.josedab.interviewbit.strings;

/**
 * https://www.interviewbit.com/problems/palindrome-string/
 *
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 *
 * Example:
 * "A man, a plan, a canal: Panama" is a palindrome.
 * "race a car" is not a palindrome.
 *
 * Return 0 / 1 ( 0 for false, 1 for true ) for this problem
 */
public class PalindromeString {

    public int isPalindrome(String a) {
        a = a.toLowerCase();
        int i = 0;
        int j = a.length() - 1;
        while (i < j) {

            // Advance i
            char charI = a.charAt(i);
            while (i < j && !isValidChar(charI)) {
                i++;
                charI = a.charAt(i);
            }

            // Advance j
            char charJ = a.charAt(j);
            while (i < j && !isValidChar(charJ)) {
                j--;
                charJ = a.charAt(j);
            }

            if (i >= j) {
                break;
            } else {
                if (charI == charJ) {
                    i++;
                    j--;
                } else {
                    return 0;
                }
            }

        }
        return 1;
    }

    public boolean isValidChar(char c) {
        return (c >= 'a' && c <= 'z') ||
                (c >= 'A' && c <= 'Z') ||
                (c >= '0' && c <= '9');
    }

    public static void main(String []args){
        PalindromeString solution = new PalindromeString();
        System.out.println(solution.isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(solution.isPalindrome("race a car"));

    }
}
