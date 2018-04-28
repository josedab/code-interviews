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


 Solution: Greedy
 Alternative: {@link MinJumpsArrayDp}
 */
public class MinJumpsArray {

    public int jump(List<Integer> steps) {
        if (steps == null || steps.size() == 0 )
            return 0;

        int lastReach = 0;
        int reach = 0;
        int step = 0;

        for (int i = 0; i <= reach && i < steps.size(); i++) {
            //when last jump can not read current i, increase the step by 1
            if (i > lastReach) {
                step++;
                lastReach = reach;
            }
            //update the maximal jump
            reach = Math.max(reach, steps.get(i) + i);
        }

        if (reach < steps.size() - 1)
            return -1;

        return step;
    }

    public static void main(String[] args) {
        MinJumpsArray solution = new MinJumpsArray();
        List<Integer> problem = Arrays.asList(2, 3, 1, 1, 4);
        System.out.println(solution.jump(problem));
    }
}
