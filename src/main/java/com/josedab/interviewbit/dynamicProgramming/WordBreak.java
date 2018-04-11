package com.josedab.interviewbit.dynamicProgramming;

import java.util.Arrays;
import java.util.List;

/**
 * Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence
 * of one or more dictionary words.

 For example, given

 s = "myinterviewtrainer",
 dict = ["trainer", "my", "interview"].
 Return 1 ( corresponding to true ) because "myinterviewtrainer" can be segmented as "my interview trainer".

 Return 0 / 1 ( 0 for false, 1 for true ) for this problem
 */
public class WordBreak {


    // DP - Backtracking with memoization
    public int wordBreak(String str, List<String> words) {
        boolean[] dp = new boolean[str.length() + 1];
        boolean result = wordBreakAux(str, words, 0, dp);
        return result ? 1 : 0;
    }

    private boolean wordBreakAux(String partialStr, List<String> dictionaryWords, int index, boolean[] dp) {
        boolean result = false;
        if (partialStr.equals("")) {
            result = true;
        } else {
            for (String str : dictionaryWords) {
                if (partialStr.startsWith(str) && !dp[index + str.length()]) {
                    dp[index + str.length()] = true;
                    result = result || wordBreakAux(partialStr.substring(str.length()), dictionaryWords, index + str.length(), dp);
                    if (result) {
                        break;
                    }
                }
            }
        }
        return result;
    }

    // Backtracking solution
    public int wordBreakBacktracking(String stringWithWords, List<String> dictionaryWords) {
        int result = 0;
        if (stringWithWords.equals("")) {
            result = 1;
        } else {
            for (String str : dictionaryWords) {
                if (stringWithWords.startsWith(str)) {
                    result |= wordBreakBacktracking(stringWithWords.substring(str.length()), dictionaryWords);
                    if (result == 1) {
                        break;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        WordBreak solution = new WordBreak();
        System.out.println(solution.wordBreak("myinterviewtrainer",
                                              Arrays.asList("interview", "my", "trainer")));
        System.out.println(solution.wordBreakBacktracking("myinterviewtrainer",
                                                          Arrays.asList("interview", "my", "trainer")));

    }
}
