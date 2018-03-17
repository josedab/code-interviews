package com.josedab.interviewbit.strings;

/**
 * You are given a string. The only operation allowed is to insert characters in
 * the beginning of the string. How many minimum characters are needed to be inserted to
 * make the string a palindrome string.
 * Variant from {@link MinCharactersToPalindrome}

 Example:
 Input: ABC
 Output: 2
 Input: AACECAAAA
 Output: 2
 */
public class MinCharactersToPalindromeFromBeginning {

    private boolean isPalindrome(String s) {
        StringBuilder reverse = new StringBuilder(s).reverse();
        if (s.equals(reverse.toString())) {
            return true;
        }
        return false;
    }

    public int solve(String A) {
        StringBuilder ps = new StringBuilder(A);
        int n = ps.length();
        if (isPalindrome(ps.toString())) {
            return 0;
        }
        int i;
        if (n % 2 == 0) {
            i = n / 2 - 1;
        } else {
            i = n / 2;
        }
        for (; i >= 0; i--) {
            if (isPalindrome(ps.substring(0, 2 * i + 1))) {
                return (n - 1) - (2 * i);
            } else if (isPalindrome(ps.substring(0, 2 * i))) {
                return (n - 1) - (2 * i - 1);
            }
        }
        return n;
    }

    public static void main(String[] args) {
        MinCharactersToPalindromeFromBeginning solution = new MinCharactersToPalindromeFromBeginning();
        System.out.println(solution.solve("ABC"));
        System.out.println(solution.solve("Banana"));
    }
}
