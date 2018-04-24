package com.josedab.interviewbit.strings;

import java.math.BigInteger;

/**
 * Find if Given number is power of 2 or not.
 More specifically, find if given number can be expressed as 2^k where k >= 1.

 Input:

 number length can be more than 64, which mean number can be greater than 2 ^ 64 (out of long long range)
 Output:

 return 1 if the number is a power of 2 else return 0

 Example:

 Input : 128
 Output : 1

 */
public class PowerOfTwo {

    /*
     Solution: use of string processing

     Loop until n not equal to 1 and also n is even :
        n divided by 2
        IF n is equal to 1
                return 1
        ELSE
            return 0

      This solution implements division by 2 as we learnt it at school
      */
    public int power(String str) {

        if (str == null)
            return 0;
        char arr[] = str.toCharArray();

        int start = 0;
        int end = arr.length - 1;

        while (start < end) {

            if (((int) arr[end] - '0') % 2 != 0)
                return 0;
            for (int i = start, carryOver = 0; i <= end; i++) {
                int currElement = (int) arr[i] - '0';
                currElement = 10 * carryOver + currElement;

                if (currElement < 2) {
                    arr[i] = '0';
                    carryOver = currElement;
                } else {
                    arr[i] = (char) ('0' + currElement / 2);
                    carryOver = currElement % 2;
                }
            }

            if (arr[start] == '0')
                start++;
        }
        if (((int) arr[end] - '0') % 2 == 0)
            return 1;
        return 0;

    }

    // Solution: Use of BigInteger
    public int powerV2(String str) {
        if (str.equals("1")) {
            return 0;
        }

        BigInteger num = new BigInteger(str);
        int lowestSetBit = num.getLowestSetBit();
        num = num.clearBit(lowestSetBit);
        return num.equals(BigInteger.ZERO) ? 1 : 0;
    }

    public static void main(String[] args) {
        PowerOfTwo solution = new PowerOfTwo();
        System.out.println(solution.power("128"));
        System.out.println(solution.powerV2("128"));
    }

}
