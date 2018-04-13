package com.josedab.interviewbit.dynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.

 Return all such possible sentences.

 For example, given

 s = "catsanddog",
 dict = ["cat", "cats", "and", "sand", "dog"].
 A solution is

 [
 "cat sand dog",
 "cats and dog"
 ]
 Make sure the strings are sorted in your result.

 Solution: Backtracking (It is necessary), however there is a better version of this backtracking
 that includes memoization.

 You start exploring every substring from the start of the string,
 and check if its in the dictionary.
 If it is, then you check if it is possible to form rest of the
 string using the dictionary words.
 If yes, you append the current substring to all the substring possible
 from rest of the string. If none of the substrings qualify,
 then there are no sentences possible from this string.
 */
public class WordBreakII {

    public ArrayList<String> wordBreak(String str, List<String> dictionaryWords) {
        Map<String, ArrayList<String>> memoization = new HashMap<>();
        return helper(str, dictionaryWords, memoization);
    }

    /**
     * Helper method finds all valid sentences and uses memoization
     */
    private ArrayList<String> helper(String str, List<String> dictionaryWords, Map<String, ArrayList<String>> memoization) {
        if (memoization.containsKey(str))
            return memoization.get(str);

        ArrayList<String> result = new ArrayList<String>();
        for (int i = 0; i < str.length(); i++) {
            String prefix = str.substring(0, i + 1);
            if (dictionaryWords.indexOf(prefix) != -1) {
                if (i < str.length() - 1) {
                    for (String temp : helper(str.substring(i + 1), dictionaryWords, memoization)) {
                        result.add(prefix + " " + temp);
                    }
                } else {
                    result.add(prefix);
                }
            }
        }

        memoization.put(str, result);
        return result;
    }

    public static void main(String[] args) {
        WordBreakII solution = new WordBreakII();
        System.out.println(solution.wordBreak("catsanddog",
                                              Arrays.asList("cat", "cats", "and", "sand", "dog")));

    }
}
