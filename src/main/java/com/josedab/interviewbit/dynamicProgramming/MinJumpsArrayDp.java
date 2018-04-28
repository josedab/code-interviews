package com.josedab.interviewbit.dynamicProgramming;

import java.util.Arrays;
import java.util.List;

/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.

 Each element in the array represents your maximum jump length at that position.

 Your goal is to reach the last index in the minimum number of jumps.

 Example :
 Given array A = [2,3,1,1,4]

 The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1,
 then 3 steps to the last index.)

 If it is not possible to reach the end index, return -1.


 Solution: dp
 */
public class MinJumpsArrayDp {

    public int jump(List<Integer> steps) {
        int[] dp = new int[steps.size()];
        for (int i = 0; i < steps.size(); i++) {
            dp[i] = -1;
        }
        dp[0] = 0;
        for (int i = 0; i < steps.size(); i++) {
            if (dp[i] == -1) {
                continue;
            }

            for (int j = 1; j <= steps.get(i); j++) {
                int index = i + j;
                int jumps = 1 + dp[i];
                if (index >= steps.size()) {
                    break;
                } else {
                    dp[index] = dp[index] > -1 ? Math.min(jumps, dp[index]) : jumps;
                }
            }
        }
        return dp[steps.size() - 1];

    }

    public static void main(String[] args) {
        MinJumpsArrayDp solution = new MinJumpsArrayDp();
        List<Integer> problem = Arrays.asList(2, 3, 1, 1, 4);
        System.out.println(solution.jump(problem));
    }
}
