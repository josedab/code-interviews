package com.josedab.interviewbit.greedy;

import java.util.Arrays;
import java.util.List;

/**
 * N light bulbs are connected by a wire. Each bulb has a switch associated with it, however due to faulty wiring, a switch also changes the state of all the bulbs to the right of current bulb. Given an initial state of all bulbs, find the minimum number of switches you have to press to turn on all the bulbs. You can press the same switch multiple times.

 Note : 0 represents the bulb is off and 1 represents the bulb is on.

 Example:

 Input : [0 1 0 1]
 Return : 4

 Explanation :
 press switch 0 : [1 0 1 0]
 press switch 1 : [1 1 0 1]
 press switch 2 : [1 1 1 0]
 press switch 3 : [1 1 1 1]
 */
public class Bulbs {
    public int bulbs(List<Integer> list) {
        int result = 0;
        int change = 0;
        for (int switchValue : list) {
            if ((switchValue + change) % 2 == 0) {
                result++;
                change = ~change;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Bulbs solution = new Bulbs();
        System.out.println(solution.bulbs(Arrays.asList(0, 1, 0, 1)));
    }
}
