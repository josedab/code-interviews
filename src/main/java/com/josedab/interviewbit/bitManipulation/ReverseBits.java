package com.josedab.interviewbit.bitManipulation;

/**
 * Reverse bits of an 32 bit unsigned integer

 Example 1:

 x = 0,

 00000000000000000000000000000000
 =>        00000000000000000000000000000000
 return 0

 Example 2:

 x = 3,

 00000000000000000000000000000011
 =>        11000000000000000000000000000000
 return 3221225472

 Since java does not have unsigned int, use long
 */
public class ReverseBits {
    public long reverse(long a) {
        long result = 0;
        int elements = 0;
        while (elements < 32) {
            int digit = (int) (a % 2);
            a = a >> 1;
            result = result << 1;
            result = result + digit;
            elements++;
        }
        return result;
    }

    public static void main(String[] args) {
        ReverseBits solution = new ReverseBits();
        System.out.println(solution.reverse(3));
    }
}
