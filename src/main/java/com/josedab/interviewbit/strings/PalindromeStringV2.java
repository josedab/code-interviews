package com.josedab.interviewbit.strings;

/**
 * https://www.interviewbit.com/problems/palindrome-string/
 * <p>
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 * <p>
 * Example:
 * "A man, a plan, a canal: Panama" is a palindrome.
 * "race a car" is not a palindrome.
 * <p>
 * Return 0 / 1 ( 0 for false, 1 for true ) for this problem
 *
 *
 * Note: Improvement of v1. Code looks cleaner, mindset needs to be on every iteration rather than complicating
 * work inside a loop. Normally that means messy code and difficult to explain and understand.
 */
public class PalindromeStringV2 {

    public int isPalindrome(String str) {

        String tempStr = str.toLowerCase();
        int i = 0;
        int j = tempStr.length() - 1;

        while (i < j) {
            char charI = tempStr.charAt(i);
            char charJ = tempStr.charAt(j);

            if (!isACharacter(charI)) {
                i++;
            } else if (!isACharacter(charJ)) {
                j--;
            } else if (charI != charJ) {
                return 0;
            } else {
                i++;
                j--;
            }


        }
        return 1;
    }

    private boolean isACharacter(char c) {
        return (c >= 'a' && c <= 'z') ||
                (c >= 'A' && c <= 'Z') ||
                (c >= '0' && c <= '9');
    }

    public static void main(String[] args) {
        PalindromeStringV2 solution = new PalindromeStringV2();
        System.out.println(solution.isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(solution.isPalindrome("race a car"));

    }
}
