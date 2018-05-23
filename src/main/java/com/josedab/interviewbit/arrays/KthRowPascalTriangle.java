package com.josedab.interviewbit.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an index k, return the kth row of the Pascal’s triangle.

 Pascal’s triangle : To generate A[C] in row R, sum up A’[C] and A’[C-1] from previous row R - 1.

 Example:

 Input : k = 3

 Return : [1,3,3,1]
 NOTE : k is 0 based. k = 0, corresponds to the row [1].
 Note:Could you optimize your algorithm to use only O(k) extra space?
 */
public class KthRowPascalTriangle {
    public List<Integer> getRow(int k) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i <= k; i++) {
            result.add(1);
        }
        for (int i = 2; i <= k; i++) {
            for (int j = i - 1; j > 0; j--) {
                result.set(j, result.get(j) + result.get(j - 1));
            }
        }
        return result;

    }

    public static void main(String[] args) {
        KthRowPascalTriangle solution = new KthRowPascalTriangle();
        System.out.println(solution.getRow(3));
    }
}
