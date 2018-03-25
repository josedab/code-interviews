package com.josedab.interviewbit.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Given a digit string, return all possible letter combinations that the number could represent.

 A mapping of digit to letters (just like on the telephone buttons) is given below.
 http://upload.wikimedia.org/wikipedia/commons/thumb/7/73/Telephone-keypad2.svg/200px-Telephone-keypad2.svg.png

 The digit 0 maps to 0 itself.
 The digit 1 maps to 1 itself.

 Input: Digit string "23"
 Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].

 */
public class LetterPhone {
    private Map<Character, String> dict;

    public LetterPhone() {
        dict = new HashMap<>();
        dict.put(Character.valueOf('0'), "0");
        dict.put(Character.valueOf('1'), "1");
        dict.put(Character.valueOf('2'), "abc");
        dict.put(Character.valueOf('3'), "def");
        dict.put(Character.valueOf('4'), "ghi");
        dict.put(Character.valueOf('5'), "jkl");
        dict.put(Character.valueOf('6'), "mno");
        dict.put(Character.valueOf('7'), "pqrs");
        dict.put(Character.valueOf('8'), "tuv");
        dict.put(Character.valueOf('9'), "wxyz");
    }

    public ArrayList<String> letterCombinations(String A) {
        ArrayList<String> result = new ArrayList<String>();
        letterCombinationsAux(A, 0, "", result);
        return result;
    }

    private void letterCombinationsAux(String str, int indexCandidate,
                                       String partialResult, ArrayList<String> result) {

        if (indexCandidate >= str.length()) {
            result.add(partialResult);
        } else {
            Character charCandidate = str.charAt(indexCandidate);
            String candidates = dict.get(charCandidate);
            for (int i = 0; i < candidates.length(); i++) {
                Character c = candidates.charAt(i);
                letterCombinationsAux(str, indexCandidate + 1, partialResult + c, result);
            }
        }
    }

    public static void main(String[] args) {
        LetterPhone solution = new LetterPhone();
        System.out.println(solution.letterCombinations("23"));
    }
}
