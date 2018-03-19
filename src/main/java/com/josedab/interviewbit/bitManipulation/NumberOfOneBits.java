package com.josedab.interviewbit.bitManipulation;

/**
 * Write a function that takes an unsigned integer and returns the number of 1 bits it has.

 Example:

 The 32-bit integer 11 has binary representation

 00000000000000000000000000001011
 so the function should return 3.

 Note that since Java does not have unsigned int, use long for Java
 */
public class NumberOfOneBits {

    // Bitwise operation calculation
    public int numSetBits(long a) {
        int result = 0;
        while (a > 0) {
            if ((a & 1) != 0) {
                result++;
            }
            a = a >> 1;
        }
        return result;
    }

    // Math division operation calculation
    public int numSetBitsAlternative(long a) {
        int result = 0;
        while (a > 0) {
            if (a % 2 != 0) {
                result++;
            }
            a = a / 2;
        }
        return result;
    }

    // Bitwise operation: removing latest bit set to 1
    public int numSetBitsBitwiseDestructionAlternative(long x) {
        int result = 0;
        while (x != 0) {
            x = x & (x - 1);
            result++;
        }
        return result;
    }

    public static void main(String[] args) {
        NumberOfOneBits solution = new NumberOfOneBits();

        System.out.println(solution.numSetBits(2));
        System.out.println(solution.numSetBits(Integer.MAX_VALUE));

        System.out.println(solution.numSetBitsAlternative(2));
        System.out.println(solution.numSetBitsAlternative(Integer.MAX_VALUE));

        System.out.println(solution.numSetBitsBitwiseDestructionAlternative(2));
        System.out.println(solution.numSetBitsBitwiseDestructionAlternative(Integer.MAX_VALUE));

    }
}
