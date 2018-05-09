package com.josedab.interviewbit.dynamicProgramming;

/**
 * Given two words A and B, find the minimum number of steps required to convert A to B. (each operation is counted as 1 step.)

 You have the following 3 operations permitted on a word:

 Insert a character
 Delete a character
 Replace a character
 Example :
 edit distance between
 "Anshuman" and "Antihuman" is 2.

 Operation 1: Replace s with t.
 Operation 2: Insert i.
 */
public class EditDistance {
    public int minDistance(String strA, String strB) {

        // Create a table to store results of subproblems
        int lenA = strA.length();
        int lenB = strB.length();
        int dp[][] = new int[lenA + 1][lenB + 1];

        // Fill dp[][] in bottom up manner
        for (int i = 0; i <= lenA; i++) {
            for (int j = 0; j <= lenB; j++) {
                // If first string is empty, only option is to
                // insert all characters of second string
                if (i == 0)
                    dp[i][j] = j;  // Min. operations = j

                    // If second string is empty, only option is to
                    // remove all characters of second string
                else if (j == 0)
                    dp[i][j] = i; // Min. operations = i

                    // If last characters are same, ignore last char
                    // and recur for remaining string
                else if (strA.charAt(i - 1) == strB.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];

                    // If last character are different, consider all
                    // possibilities and find minimum
                else
                    dp[i][j] = 1 + min(dp[i][j - 1],  // Insert
                                       dp[i - 1][j],  // Remove
                                       dp[i - 1][j - 1]); // Replace
            }
        }

        return dp[lenA][lenB];
    }

    private int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }

    public static void main(String[] args) {
        EditDistance solution = new EditDistance();
        System.out.println(solution.minDistance("car", "cars"));
    }
}
