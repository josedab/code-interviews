package com.josedab.interviewbit.strings;

/**
 * Given an input string, reverse the string word by word.

 Example:

 Given s = "the sky is blue",

 return "blue is sky the".

 A sequence of non-space characters constitutes a word.
 Your reversed string should not contain leading or trailing spaces, even if it is present in the input string.
 If there are multiple spaces between words, reduce them to a single space in the reversed string.

 Solution:
 There are two kinds of thoughts:
 - You could split the string into words with split() and visit them in reverse order (2 passes)
 - You could have start and end indexes with temporary string builders and do it in one pass
 Both solutions are O(n), we will go with the most readable one. We could also point the fact of someone
 doing str.trim() could add an extra iteration. Benchmarking to determine the right solution would be necessary as
 String also get cached on the jvm pool.
 */
public class ReverseTheString {

    // O(n) - 2 passes
    public String reverseWords(String str) {
        StringBuilder sb = new StringBuilder();
        String[] words = str.split(" ");
        for (int i = words.length - 1; i >= 0; i--) {
            sb.append(words[i]);
            if (i != 0) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }



    public static void main(String[] args) {
        ReverseTheString solution = new ReverseTheString();
        System.out.println(solution.reverseWords("the sky is blue"));
    }
}
