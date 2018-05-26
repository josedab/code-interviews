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
public class ShortestCommonSuperstring {

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
    public int solve(ArrayList<String> list) {

        int length = list.size();

        // run len-1 times to consider every pair
        while (length != 1) {
            int max = Integer.MIN_VALUE;
            int l = -1, r = -1;
            String result = "";  // to store resultant string after
            // maximum overlap

            for (int i = 0; i < length; i++) {
                for (int j = i + 1; j < length; j++) {

                    // res will store maximum length of the matching
                    // prefix and suffix str is passed by reference and
                    // will store the resultant string after maximum
                    // overlap of arr[i] and arr[j], if any.
                    String res = findSuperString(list.get(i), list.get(j));

                    // check for maximum overlap
                    if (max < res.length()) {
                        max = res.length();
                        result = res;
                        l = i;
                        r = j;
                    }
                }
            }


            // if no overlap, append arr[len] to arr[0]
            if (max <= 0)
                list.set(0, list.get(0) + list.get(length - 1));
            else {
                list.set(l, result);
                list.set(r, list.get(length - 1));
            }

            length--;
        }

        return list.get(0).length();
    }

    private String findSuperString(String str1, String str2) {
        String result = "";
        int max = Integer.MIN_VALUE;
        int strLength1 = str1.length();
        int strLength2 = str2.length();

        // check suffix of str1 matches with prefix of str2
        for (int i = 1; i <= Math.min(strLength1, strLength2); i++) {
            // compare last i characters in str1 with first i characters in str2
            if (str1.substring(strLength1 - i).equals(str2.substring(0, i))) {
                if (max < i) {
                    //update max and str
                    max = i;
                    result = str1 + str2.substring(i);
                }
            }
        }

        // check prefix of str1 matches with suffix of str2
        for (int i = 1; i <= Math.min(strLength1, strLength2); i++) {
            // compare first i characters in str1 with last i characters in str2
            if (str2.substring(strLength2 - i).equals(str1.substring(0, i))) {
                if (max < i) {
                    //update max and str
                    max = i;
                    result = str2 + str1.substring(i);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        ShortestCommonSuperstring solution = new ShortestCommonSuperstring();
        System.out.println(solution.solve(new ArrayList(Arrays.asList("bcd", "ef", "gh"))));
    }
}
