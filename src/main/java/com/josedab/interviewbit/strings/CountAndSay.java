package com.josedab.interviewbit.strings;

/**
 * The count-and-say sequence is the sequence of integers beginning as follows:

 1, 11, 21, 1211, 111221, ...
 1 is read off as one 1 or 11.
 11 is read off as two 1s or 21.

 21 is read off as one 2, then one 1 or 1211.

 Given an integer n, generate the nth sequence.

 Note: The sequence of integers will be represented as a string.

 Example:

 if n = 2,
 the sequence is 11.
 */
public class CountAndSay {

    public String countAndSay(int n) {

        if (n == 0) return "";

        String str = "1";

        for (int i = 1; i < n; i++) {
            StringBuffer candidate = new StringBuffer();
            char previousChar = str.charAt(0);
            int count = 1;

            for (int j = 1; j < str.length(); j++) {
                char currentChar = str.charAt(j);
                if (currentChar != previousChar) {
                    candidate.append(count).append(previousChar);
                    previousChar = currentChar;
                    count = 1;
                } else {
                    count++;
                }
            }

            candidate.append(count).append(previousChar);
            str = candidate.toString();
        }
        return str;
    }

    public static void main(String[] args) {
        CountAndSay solution = new CountAndSay();
        System.out.println(solution.countAndSay(3));
    }
}
