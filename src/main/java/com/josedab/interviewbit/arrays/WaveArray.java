package com.josedab.interviewbit.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Given an array of integers, sort the array into a wave like array and return it,
 * In other words, arrange the elements into a sequence such that a1 >= a2 <= a3 >= a4 <= a5.....
 *
 * Example
 *
 * Given [1, 2, 3, 4]
 *
 * One possible answer : [2, 1, 4, 3]
 * Another possible answer : [4, 1, 3, 2]
 * NOTE : If there are multiple answers possible, return the one that's lexicographically smallest.
 * So, in example case, you will return [2, 1, 4, 3]
 */
public class WaveArray {
    public List<Integer> wave(List<Integer> a) {
        Collections.sort(a);
        for (int i = 1; i < a.size(); i += 2) {
            int temporal = a.get(i);
            a.set(i, a.get(i - 1));
            a.set(i - 1, temporal);
        }
        return a;
    }

    public static void main(String[] args) {
        List<Integer> test = Arrays.asList(1, 2, 3, 4);
        WaveArray solution = new WaveArray();

        System.out.println(solution.wave(test));
    }
}
