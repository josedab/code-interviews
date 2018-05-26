package com.josedab.interviewbit.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string s, partition s such that every string of the partition is a palindrome.

 Return all possible palindrome partitioning of s.

 For example, given s = "aab",
 Return

 [
 ["a","a","b"]
 ["aa","b"],
 ]
 Ordering the results in the answer : Entry i will come before Entry j if :
 len(Entryi[0]) < len(Entryj[0]) OR
 (len(Entryi[0]) == len(Entryj[0]) AND len(Entryi[1]) < len(Entryj[1])) OR
 *
 *
 *
 (len(Entryi[0]) == len(Entryj[0]) AND … len(Entryi[k] < len(Entryj[k]))
 In the given example,
 ["a", "a", "b"] comes before ["aa", "b"] because len("a") < len("aa")


 */
public class PalindromePartitioning {

    public List<List<String>> partition(String str) {
        List<List<String>> result = new ArrayList<>();
        List<String> candidate = new ArrayList<>();
        result = addStrings(result, str, candidate, 0);
        return result;
    }

    List<List<String>> addStrings(List<List<String>> results, String strCad,
                                  List<String> candidate, int index) {
        int len = strCad.length();
        String str = "";
        ArrayList<String> current = new ArrayList<>(candidate);

        if (index == 0)
            candidate.clear();

        // Iterate over the string
        for (int i = index; i < len; ++i) {
            str = str + str.charAt(i);

            // check whether the substring is
            // palindromic or not
            if (checkPalindrome(str)) {
                // if palindrome add it to temp list
                candidate.add(str);

                if (i + 1 < len) {
                    // recurr to get all the palindromic
                    // partitions for the substrings
                    results = addStrings(results, str, candidate, i + 1);
                } else {
                    // if end of the string is reached
                    // add temp to v
                    results.add(candidate);
                }

                // temp is reinitialize with the
                // current i.
                candidate = new ArrayList<>(current);
            }
        }
        return results;
    }

    boolean checkPalindrome(String str) {
        int len = str.length();
        len--;
        for (int i = 0; i < len; i++) {
            if (str.charAt(i) != str.charAt(len))
                return false;
            len--;
        }
        return true;
    }

    public static void main(String[] args) {
        PalindromePartitioning result = new PalindromePartitioning();
        System.out.println(result.partition("aab"));
    }
}
