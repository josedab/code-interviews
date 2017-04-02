package com.josedab.interviewbit.math;

/**
 * Determine whether an integer is a palindrome. Do this without extra space.
 *
 * A palindrome integer is an integer x for which reverse(x) = x where reverse(x) is x with its digit reversed.
 * Negative numbers are not palindromic.
 *
 * Example :
 *
 * Input : 12121
 * Output : True
 * 
 * Input : 123
 * Output : False
 */
public class PalindromeInteger {
    public boolean isPalindrome(int a) {

        if (a < 0) {
            return false;
        }

        int log = (int) Math.log10(a);
        int i = 0;
        int j = log;
        while (j > i) {

            int upLimit = (a / (int) (Math.pow(10, j))) % 10;
            int lowLimit = (a / (int) (Math.pow(10, i))) % 10;
            if (upLimit != lowLimit) {
                return false;
            }
            j--;
            i++;
        }

        return true;
    }

    public static void main(String[] args) {
        PalindromeInteger solution = new PalindromeInteger();
        System.out.println(solution.isPalindrome(121));
        System.out.println(solution.isPalindrome(1234321));
    }
}
