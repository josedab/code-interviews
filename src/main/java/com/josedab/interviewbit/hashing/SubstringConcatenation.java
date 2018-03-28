package com.josedab.interviewbit.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * You are given a string, S, and a list of words, L, that are all of the same length.

 Find all starting indices of substring(s) in S that is a concatenation of each word in L exactly once and without any intervening characters.

 Example :

 S: "barfoothefoobarman"
 L: ["foo", "bar"]
 You should return the indices: [0,9].
 (order does not matter).
 */
public class SubstringConcatenation {
    public ArrayList<Integer> findSubstring(String A, final List<String> B) {
        ArrayList<Integer> res = new ArrayList<>();
        if (A == null || A.length() == 0 ||
                B == null || B.size() == 0)
            return res;

        Map<String, Integer> wordsFreq = new HashMap<>();
        int len = 0;

        for (String str : B) {
            int val = 1;
            if (wordsFreq.containsKey(str)) {
                val = wordsFreq.get(str) + 1;
            }
            wordsFreq.put(str, val);
            len = str.length();
        }

        int size = B.size();
        int index;

        for (int i = 0; i <= A.length() - len * size; i++) {

            index = i;
            int loop = size;
            Map<String, Integer> hashMap = new HashMap<>(wordsFreq);

            for (int j = 0; j < loop; j++) {
                String str = A.substring(index + j * len, index + j * len + len);
                if (hashMap.containsKey(str)) {
                    int val = hashMap.get(str);
                    if (val == 1) {
                        hashMap.remove(str);
                    } else {
                        hashMap.put(str, val - 1);
                    }
                } else {
                    break;
                }
            }

            if (hashMap.isEmpty()) {
                res.add(i);
            }

        }

        return res;

    }

    public static void main(String[] args) {
        SubstringConcatenation solution = new SubstringConcatenation();
        System.out.println(solution.findSubstring("barfoothefoobarman", Arrays.asList("foo", "bar")));
    }
}
