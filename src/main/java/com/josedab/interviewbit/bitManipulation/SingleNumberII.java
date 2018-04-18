package com.josedab.interviewbit.bitManipulation;

import java.util.Arrays;
import java.util.List;

/**
 * Given an array of integers, every element appears thrice except for one which occurs once.

 Find that element which does not appear thrice.

 Note: Your algorithm should have a linear runtime complexity.

 Could you implement it without using extra memory?

 Example :

 Input : [1, 2, 4, 3, 3, 2, 2, 3, 1, 1]
 Output : 4

 */
public class SingleNumberII {

    public int singleNumber(final List<Integer> A) {

        int result = 0;
        for (int i = 0; i < 32; i++) {
            int counter = 0;
            for (int number : A) {
                counter += (number & (1 << i)) > 0 ? 1 : 0;
            }
            counter = counter % 3;
            result += counter << i;
        }
        return result;
    }

    public static void main(String []args){
        SingleNumberII solution = new SingleNumberII();
        System.out.println(solution.singleNumber(Arrays.asList(1, 2, 4, 3, 3, 2, 2, 3, 1, 1)));
    }
}
