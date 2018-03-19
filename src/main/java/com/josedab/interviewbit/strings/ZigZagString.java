package com.josedab.interviewbit.strings;

/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

 P.......A........H.......N
 ..A..P....L....S....I...I....G
 ....Y.........I........R
 And then read line by line: PAHNAPLSIIGYIR
 Write the code that will take a string and make this conversion given a number of rows:

 string convert(string text, int nRows);
 convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR"
 **Example 2 : **
 ABCD, 2 can be written as

 A....C
 ...B....D
 and hence the answer would be ACBD.
 */
public class ZigZagString {
    public String convert(String A, int B) {
        StringBuilder solution = new StringBuilder();
        if (B == 1) {
            return A;
        }

        StringBuilder[] sbArray = new StringBuilder[B];
        for (int i = 0; i < B; i++) {
            sbArray[i] = new StringBuilder();
        }

        int sbIndex = 0;
        boolean isDirectionAscending = true;
        for (int i = 0; i < A.length(); i++) {
            char c = A.charAt(i);
            sbArray[sbIndex].append(c);

            if (!isDirectionAscending && sbIndex == 0) {
                isDirectionAscending = true;
            } else if (isDirectionAscending && sbIndex == (B - 1)) {
                isDirectionAscending = false;
            }

            sbIndex += isDirectionAscending ? 1 : -1;
        }

        for (int i = 0; i < B; i++) {
            solution.append(sbArray[i]);
        }
        return solution.toString();
    }

    public static void main(String[] args) {
        ZigZagString solution = new ZigZagString();
        System.out.println(solution.convert("ABCD", 2));
        System.out.println(solution.convert("ABCD", 1));
        System.out.println(solution.convert("PAYPALISHIRING", 3));
    }
}
