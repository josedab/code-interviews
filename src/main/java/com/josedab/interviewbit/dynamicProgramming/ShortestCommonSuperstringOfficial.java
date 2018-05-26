package com.josedab.interviewbit.dynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Given a set of strings. Find the length of smallest string which
 has all the strings in the set as substring

 Constraints:
 1) 1 <= Number of strings <= 18
 2) Length of any string in the set will not exceed 100.

 Example:
 Input: [“abcd”, “cdef”, “fgh”, “de”]
 Output: 8 (Shortest string: “abcdefgh”)
 */
public class ShortestCommonSuperstringOfficial {

    /*
    Let arr[] be given set of strings.

    1) Create an auxiliary array of strings, temp[].  Copy contents
       of arr[] to temp[]

    2) While temp[] contains more than one strings
         a) Find the most overlapping string pair in temp[]. Let this
            pair be 'a' and 'b'.
         b) Replace 'a' and 'b' with the string obtained after combining
            them.

    3) The only string left in temp[] is the result, return it.
     */
    public int solve(ArrayList<String> listStr) {
        if (listStr == null) return 0;

        int n = listStr.size();
        if (n == 0) return 0;

        String[] arrStr = listStr.toArray(new String[n]);

        int len = n;
        while (len > 1) {
            int overlapMax = 0;
            int I = 0, J = 0;
            String resStr = "";
            for (int i = 0; i < len; i++) {
                for (int j = i + 1; j < len; j++) {
                    String curStr = findOverlap(arrStr[i], arrStr[j]);
                    int overlapCur = -curStr.length() + arrStr[i].length() + arrStr[j].length();
                    //System.out.println(i + " " + j + " " + curStr);
                    if (overlapMax < overlapCur) {
                        overlapMax = overlapCur;
                        resStr = curStr;
                        I = i;
                        J = j;
                    }
                }
            }
            --len;
            if (overlapMax == 0) {
                arrStr[0] += arrStr[len];
            } else {
                arrStr[I] = resStr;
                arrStr[J] = arrStr[len];
            }
        }
        return arrStr[0].length();
    }

    private String findOverlap(String a, String b) {
        int la = a.length();
        int lb = b.length();
        String res = a + b;
        for (int k = 1; k <= la; k++) {
            if (k > lb) break;
            if (b.endsWith(a.substring(0, k))) {
                res = b + a.substring(k);
            }
        }
        for (int k = 1; k <= lb; k++) {
            if (k > la) break;
            if (a.endsWith(b.substring(0, k))) {
                String tmpRes = a + b.substring(k);
                if (res.length() > tmpRes.length())
                    res = tmpRes;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        ShortestCommonSuperstringOfficial solution = new ShortestCommonSuperstringOfficial();
        System.out.println(solution.solve(new ArrayList(Arrays.asList("bcd", "ef", "gh"))));
    }
}
