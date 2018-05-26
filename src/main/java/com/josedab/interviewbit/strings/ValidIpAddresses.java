package com.josedab.interviewbit.strings;

import java.util.ArrayList;

/**
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.

     A valid IP address must be in the form of A.B.C.D, where A,B,C and D are numbers from 0-255.
     The numbers cannot be 0 prefixed unless they are 0.

     Example:

     Given “25525511135”,

     return [“255.255.11.135”, “255.255.111.35”]. (Make sure the returned strings are sorted in order)

 */
public class ValidIpAddresses {

    public ArrayList<String> restoreIpAddresses(String str) {
        ArrayList<String> result = new ArrayList<>();
        dfs("", str, result, 0);
        return result;
    }

    private void dfs(String candidate, String str, ArrayList<String> result, int count) {
        if (count == 3 && isValidNumberForIp(str)) {
            result.add(candidate + str);
            return;
        }
        for (int i = 1; i <=3 && i < str.length(); i++) {
            String substr = str.substring(0, i);
            if (isValidNumberForIp(substr)) {
                dfs(candidate + substr + '.', str.substring(i), result, count + 1);
            }
        }
    }

    private boolean isValidNumberForIp(String s) {
        if (s.charAt(0) == '0') return s.equals("0");
        int num = Integer.parseInt(s);
        return num <= 255 && num > 0;
    }


    public static void main(String[] args) {
        ValidIpAddresses solution = new ValidIpAddresses();
        System.out.println(solution.restoreIpAddresses("25525511135"));
    }
}
