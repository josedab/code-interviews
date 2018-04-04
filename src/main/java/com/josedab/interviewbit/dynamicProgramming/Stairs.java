package com.josedab.interviewbit.dynamicProgramming;

/**
 * You are climbing a stair case. It takes n steps to reach to the top.

 Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

 Example :

 Input : 3
 Return : 3

 Steps : [1 1 1], [1 2], [2 1]
 */
public class Stairs {
    public int climbStairs(int A) {
        int f1 = 1;
        int f2 = 2;
        int result = -1;

        if (A == 1) {
            result = f1;
        }
        if (A == 2) {
            result = f2;
        }
        for (int i = 3; i <= A; i++) {
            int temp = f2;
            f2 = f1 + f2;
            f1 = temp;
            result = f2;
        }
        return result;
    }

    public static void main(String []args){
        Stairs solution = new Stairs();
        System.out.println(solution.climbStairs(4));
        System.out.println(solution.climbStairs(5));
        System.out.println(solution.climbStairs(6));

    }
}
