package com.josedab.interviewbit.strings;

/**
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

 If the last word does not exist, return 0.

 Note: A word is defined as a character sequence consists of non-space characters only.

 Example:

 Given s = "Hello World",

 return 5 as length("World") = 5.

 Please make sure you try to solve this problem without using library functions. Make sure you only traverse the string once.
 */
public class LengthOfLastWord {

    public int lengthOfLastWord(final String A) {
        String words[] = A.split(" ");
        if (words.length == 0) {
            return 0;
        } else {
            return words[words.length - 1].length();
        }
    }

    public static void main(String[] args) {
        LengthOfLastWord solution = new LengthOfLastWord();
        System.out.println(solution.lengthOfLastWord("Hello World"));
        System.out.println(solution.lengthOfLastWord("   "));
    }

}
