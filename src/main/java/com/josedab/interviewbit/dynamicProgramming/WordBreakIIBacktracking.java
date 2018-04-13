package com.josedab.interviewbit.dynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
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
 that includes memoization
 */
public class WordBreakIIBacktracking {

    public ArrayList<String> wordBreak(String A, List<String> B) {
        ArrayList<String> result = new ArrayList<>();
        List<String> words = new LinkedList<>(new HashSet<>(B));
        wordBreakBacktracking(new Stack<>(), A, words, result);
        Collections.sort(result);
        return result;
    }

    private void wordBreakBacktracking(Stack<String> wordStack,
                                       String stringWithWords,
                                       List<String> dictionaryWords,
                                       List<String> result) {
        if (stringWithWords.equals("")) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < wordStack.size(); i++) {
                sb.append(wordStack.get(i));
                if (i != (wordStack.size() - 1)) {
                    sb.append(" ");
                }
            }
            result.add(sb.toString());
        } else {
            for (String str : dictionaryWords) {
                if (stringWithWords.startsWith(str)) {
                    wordStack.push(str);
                    wordBreakBacktracking(wordStack, stringWithWords.substring(str.length()), dictionaryWords, result);
                    wordStack.pop();
                }
            }
        }
    }

    public static void main(String[] args) {
        WordBreakIIBacktracking solution = new WordBreakIIBacktracking();
        System.out.println(solution.wordBreak("catsanddog",
                           Arrays.asList("cat", "cats", "and", "sand", "dog")));

    }
}
