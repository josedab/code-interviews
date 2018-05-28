package com.josedab.interviewbit.dynamicProgramming;

/**
 * Given a string containing just the characters '(' and ')', find the length of
 * the longest valid (well-formed) parentheses substring.

 For "(()", the longest valid parentheses substring is "()", which has length = 2.

 Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.

 Explanation of the solution on leet code:
 https://leetcode.com/problems/longest-valid-parentheses/solution/
 */
public class LongestValidParentheses {

    /*
    Lets construct longest[i] where longest[i] denotes the longest set of parenthesis ending at index i.

    If s[i] is ‘(‘, set longest[i] to 0, because any string end with ‘(‘ cannot be a valid one.
    Else if s[i] is ‘)’
    If s[i-1] is ‘(‘, longest[i] = longest[i-2] + 2
    Else if s[i-1] is ‘)’ and s[i-longest[i-1]-1] == ‘(‘, longest[i] = longest[i-1] + 2 + longest[i-longest[i-1]-2]

     */
    public int longestValidParentheses(String str) {
        int result = 0;
        int dp[] = new int[str.length()];
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == ')') {
                if (str.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && str.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                result = Math.max(result, dp[i]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LongestValidParentheses solution = new LongestValidParentheses();
        System.out.println(solution.longestValidParentheses("(()()"));
    }
}
