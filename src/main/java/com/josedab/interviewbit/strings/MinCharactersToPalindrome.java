package com.josedab.interviewbit.strings;

/**
 * You are given a string. The only operation allowed is insertion of characters on the string.
 * How many minimum characters are needed to be inserted in order to
 * make the string a palindrome string
 * Variant from @{@link MinCharactersToPalindromeFromBeginning}

 Example:
 Input: ABC
 Output: 2
 Input: AACECAAAA
 Output: 2
 Input: Banana
 Output: 1
 */
public class MinCharactersToPalindrome {

    public int solve(String A) {
        return solve(A, 0, A.length()-1);
    }

    private int solve(String str, int i, int j){
        char cI = str.charAt(i);
        char cJ = str.charAt(j);
        if(i>=j){
            return 0;
        }
        if(cI == cJ){
            return solve(str, i+1, j-1);
        }else{
            return Math.min(1+ solve(str,i+1,j), 1+ solve(str, i, j-1));
        }
    }

    public static void main(String[] args) {
        MinCharactersToPalindrome solution = new MinCharactersToPalindrome();
        System.out.println(solution.solve("ABC"));
        System.out.println(solution.solve("AACECAAAA"));
        System.out.println(solution.solve("Banana"));
    }
}
