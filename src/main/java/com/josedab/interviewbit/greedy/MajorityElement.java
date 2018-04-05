package com.josedab.interviewbit.greedy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given an array of size n, find the majority element. The majority element is the element that appears more than floor(n/2) times.

 You may assume that the array is non-empty and the majority element always exist in the array.

 Example :

 Input : [2, 1, 2]
 Return  : 2 which occurs 2 times which is greater than 3/2.
 */
public class MajorityElement {
    public int majorityElement(final List<Integer> A) {
        int result = -1;
        Map<Integer, Integer> freqs = new HashMap<>();
        for (Integer element : A) {
            Integer frequencyForElement = freqs.get(element);
            if (frequencyForElement == null) {
                frequencyForElement = 1;
            } else {
                frequencyForElement += 1;
            }
            freqs.put(element, frequencyForElement);
            if (frequencyForElement > (A.size() / 2)) {
                result = element;
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        MajorityElement solution = new MajorityElement();
        System.out.println(solution.majorityElement(Arrays.asList(2, 1, 2)));
    }
}
