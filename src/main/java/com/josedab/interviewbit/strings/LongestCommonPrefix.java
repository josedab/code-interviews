package com.josedab.interviewbit.strings;

import java.util.Arrays;
import java.util.List;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.

 Longest common prefix for a pair of strings S1 and S2 is the longest string S which is the prefix of both S1 and S2.

 As an example, longest common prefix of "abcdefgh" and "abcefgh" is "abc".

 Given the array of strings, you need to find the longest S which is the prefix of ALL the strings in the array.

 Example:

 Given the array as:

 [

 "abcdefgh",

 "aefghijk",

 "abcefgh"
 ]
 The answer would be “a”.
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(List<String> A) {

        StringBuilder result = new StringBuilder();
        int minLength = Integer.MAX_VALUE;
        for (int i = 0; i < A.size(); i++) {
            minLength = Math.min(minLength, A.get(i).length());
        }

        for (int j = 0; j < minLength; j++) {
            Character previous = null;
            for (int i = 0; i < A.size(); i++) {
                String str = A.get(i);
                Character c = str.charAt(j);
                if (previous != null && !c.equals(previous)) {
                    return result.toString();
                } else {
                    previous = c;
                }
            }
            result.append(previous);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        LongestCommonPrefix solution = new LongestCommonPrefix();

        System.out.println(solution.longestCommonPrefix(
                Arrays.asList("abcd", "abde", "abcf")
        ));

        System.out.println(solution.longestCommonPrefix(
                Arrays.asList("abcd", "abcd", "efgh")
        ));

    }
}
