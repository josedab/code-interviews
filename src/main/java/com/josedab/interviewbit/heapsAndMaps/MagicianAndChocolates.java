package com.josedab.interviewbit.heapsAndMaps;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Given N bags, each bag contains Ai chocolates. There is a kid and a magician. In one unit of time, kid chooses a random bag i, eats Ai chocolates, then the magician fills the ith bag with floor(Ai/2) chocolates.

 Given Ai for 1 <= i <= N, find the maximum number of chocolates kid can eat in K units of time.

 For example,

 K = 3
 N = 2
 A = 6 5

 Return: 14
 At t = 1 kid eats 6 chocolates from bag 0, and the bag gets filled by 3 chocolates
 At t = 2 kid eats 5 chocolates from bag 1, and the bag gets filled by 2 chocolates
 At t = 3 kid eats 3 chocolates from bag 0, and the bag gets filled by 1 chocolate
 so, total number of chocolates eaten: 6 + 5 + 3 = 14

 Note: Return your answer modulo 10^9+7


 */
public class MagicianAndChocolates {

    public int nchoc(int A, List<Integer> B) {
        long result = 0;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>((o1, o2) -> o2 - o1);
        for (int i = 0; i < B.size(); i++) {
            priorityQueue.add(B.get(i));
        }

        for (int i = 0; i < A; i++) {
            Integer chocs = priorityQueue.poll();
            result += chocs;
            priorityQueue.add(chocs / 2);
        }
        return (int) (result % (Math.pow(10, 9) + 7));
    }

    public static void main(String[] args) {
        MagicianAndChocolates solution = new MagicianAndChocolates();
        System.out.println(solution.nchoc(10, Arrays.asList(2147483647, 2000000014, 2147483647)));
    }
}
