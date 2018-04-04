package com.josedab.interviewbit.dynamicProgramming;

import java.util.List;

/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.

 Each element in the array represents your maximum jump length at that position.

 Determine if you are able to reach the last index.

 For example:
 A = [2,3,1,1,4], return 1 ( true ).

 A = [3,2,1,0,4], return 0 ( false ).

 Return 0/1 for this problem
 */
public class JumpGameArray {

    public int canJump(List<Integer> A) {
        boolean[] jumps = new boolean[A.size()];

        jumps[0] = true;
        for (int i = 0; i < A.size(); i++) {
            int jumpsAvailable = A.get(i);
            if (!jumps[i]) break;
            for (int j = 1; j <= jumpsAvailable; j++) {
                int newIndex = i + j;
                if ((i + j) > A.size() - 1) {
                    newIndex = A.size() - 1;
                }
                jumps[newIndex] = true;
            }
        }

        return jumps[A.size() - 1] ? 1 : 0;
    }
}
