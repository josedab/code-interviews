package com.josedab.interviewbit.stacksAndQueues;

import java.util.Arrays;
import java.util.List;

/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
 http://i.imgur.com/0qkUFco.png
 Example :

 Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.

 Rain water trapped: Example 1

 The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1].
 In this case, 6 units of rain water (blue section) are being trapped.
 */
public class RainWaterTrapped {
    public int trap(final List<Integer> list) {

        int n = list.size();
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = list.get(0);
        right[n - 1] = list.get(n - 1);
        for (int i = 1; i < n; i++) {
            left[i] = Math.max(left[i - 1], list.get(i));
            right[n - i - 1] = Math.max(right[n - i], list.get(n - i - 1));
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            result += (Math.min(left[i], right[i]) - list.get(i));
        }
        return result;
    }

    public static void main(String []args){
        RainWaterTrapped solution = new RainWaterTrapped();
        System.out.println(solution.trap(Arrays.asList(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1)));
    }

}
