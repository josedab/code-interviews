package com.josedab.interviewbit.math;

/**
 * Determine whether an integer is a palindrome. Do this without extra space.
 * <p>
 * A palindrome integer is an integer x for which reverse(x) = x where reverse(x) is x with its digit reversed.
 * Negative numbers are not palindromic.
 * <p>
 * Example :
 * <p>
 * Input : 12121
 * Output : True
 * <p>
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

    // Solution 2: Without considering discrete mathematics
    public boolean isPalindrome2(int a) {
        String number = String.valueOf(a);
        return number.equals(new StringBuilder(number).reverse().toString());

    }

    // Solution 3: Destructuring and building the integer again based on 10 base factorizations
    public boolean isPalindrome3(int a) {
        if (a == check(a))
            return true;
        else
            return false;
    }

    private int check(int num) {
        int reverted = 0;
        while (num > 0) {
            reverted = reverted * 10 + num % 10;
            num /= 10;
        }
        return reverted;
    }

    public static void main(String[] args) {
        PalindromeInteger solution = new PalindromeInteger();
        System.out.println(solution.isPalindrome(121));
        System.out.println(solution.isPalindrome(1234321));
    }
}
