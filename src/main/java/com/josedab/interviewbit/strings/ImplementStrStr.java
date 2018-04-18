package com.josedab.interviewbit.strings;

/**
 * Another question which belongs to the category of questions which are intentionally stated vaguely.
 Expectation is that you will ask for correct clarification or you will state your assumptions before you start coding.

 Implement strStr().

 strstr - locate a substring ( needle ) in a string ( haystack ).
 Try not to use standard library string functions for this question.

 Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

 NOTE: Good clarification questions:
 What should be the return value if the needle is empty?
 What if both haystack and needle are empty?
 For the purpose of this problem, assume that the return value should be -1 in both cases.
 */
public class ImplementStrStr {
    public int strStr(final String str, final String strToSearch) {
        for (int i = 0; i < (str.length() - strToSearch.length() + 1); i++) {
            char c = str.charAt(i);
            boolean success = true;
            for (int j = 0; j < strToSearch.length(); j++) {
                if (str.charAt(i + j) != strToSearch.charAt(j)) {
                    success = false;
                    break;
                }
            }
            if (success) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        ImplementStrStr solution = new ImplementStrStr();
        System.out.println(solution.strStr("a plan", "plan"));
    }
}
