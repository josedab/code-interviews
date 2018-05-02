package com.josedab.warmup;

/**
 * Given a string S, reverse the string using stack.

 Example :

 Input : "abc"
 */
public class ReverseString {
    public String reverseString(String A) {
        StringBuilder sb = new StringBuilder();
        for (int i = A.length() - 1; i >= 0; i--) {
            sb.append(A.charAt(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        ReverseString solution = new ReverseString();
        System.out.println(solution.reverseString("asdf"));
    }
}
