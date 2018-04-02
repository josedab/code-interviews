package com.josedab.interviewbit.heapsAndMaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * You are given an array of N integers, A1, A2 ,…, AN and an integer K.
 * Return the of count of distinct numbers in all windows of size K.

 Formally, return an array of size N-K+1 where i’th element in this array contains number of distinct elements
 in sequence Ai, Ai+1 ,…, Ai+k-1.

 Note:

 If K > N, return empty array.
 For example,

 A=[1, 2, 1, 3, 4, 3] and K = 3

 All windows of size K are

 [1, 2, 1]
 [2, 1, 3]
 [1, 3, 4]
 [3, 4, 3]

 So, we return an array [2, 3, 3, 2].
 */
public class DistinctNumbersInWindow {

    public ArrayList<Integer> dNums(List<Integer> A, int B) {

        ArrayList<Integer> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < A.size(); i++) {
            if (i < (B - 1)) {
                increaseFreqIfNecessary(A.get(i), map);
            } else {
                increaseFreqIfNecessary(A.get(i), map);
                result.add(map.keySet().size());
                decreaseFreqIfNecessary(A.get(i - B + 1), map);
            }

        }
        return result;
    }

    private void increaseFreqIfNecessary(int key, Map<Integer, Integer> map) {
        if (map.containsKey(key)) {
            map.put(key, map.get(key) + 1);
        } else {
            map.put(key, 1);
        }
    }

    private void decreaseFreqIfNecessary(int key, Map<Integer, Integer> map) {
        if (map.containsKey(key)) {
            Integer freq = map.get(key);
            if (freq == 1) {
                map.remove(key);
            } else {
                map.put(key, freq - 1);
            }
        }
    }

    public static void main(String[] args) {
        DistinctNumbersInWindow solution = new DistinctNumbersInWindow();
        System.out.println(solution.dNums(Arrays.asList(1, 2, 1, 3, 4, 3), 3));
    }
}
