package com.josedab.interviewbit.backtracking;

import java.util.ArrayList;

/**
 * Created by jbaena on 5/24/18.
 */
public class PalindromePartitioning {
    public ArrayList<ArrayList<String>> partition(String str) {
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
        // temporary ArrayList to store each
        // palindromic string
        ArrayList<String> temp = new ArrayList<>();

        // calling addString method it adds all
        // the palindromic partitions to v
        result = addStrings(result, str, temp, 0);
        return result;
    }

    ArrayList<ArrayList<String>> addStrings(ArrayList<
            ArrayList<String>> v, String s, ArrayList<String> temp,
                                            int index) {
        int len = s.length();
        String str = "";
        ArrayList<String> current = new ArrayList<>(temp);

        if (index == 0)
            temp.clear();

        // Iterate over the string
        for (int i = index; i < len; ++i) {
            str = str + s.charAt(i);

            // check whether the substring is
            // palindromic or not
            if (checkPalindrome(str)) {
                // if palindrome add it to temp list
                temp.add(str);

                if (i + 1 < len) {
                    // recurr to get all the palindromic
                    // partitions for the substrings
                    v = addStrings(v, s, temp, i + 1);
                } else {
                    // if end of the string is reached
                    // add temp to v
                    v.add(temp);
                }

                // temp is reinitialize with the
                // current i.
                temp = new ArrayList<>(current);
            }
        }
        return v;
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
