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

    // O(n) runtime
    // O(n) space complexity
    public int majorityElement(final List<Integer> list) {
        int result = -1;
        Map<Integer, Integer> freqs = new HashMap<>();
        for (Integer element : list) {
            Integer frequencyForElement = freqs.get(element);
            if (frequencyForElement == null) {
                frequencyForElement = 1;
            } else {
                frequencyForElement += 1;
            }
            freqs.put(element, frequencyForElement);
            if (frequencyForElement > (list.size() / 2)) {
                result = element;
                break;
            }
        }
        return result;
    }

    /*
     Greedy approach
     If we cancel out each occurrence of an element e with all the other elements
     that are different from e then e will exist till end if it is a majority element.
     Loop through each element and maintains a count of the element that has the potential
     of being the majority element. If next element is same then increments the count,
     otherwise decrements the count.

     If the count reaches 0 then update the potential index to the current element and reset count to 1.

     O(n) runtime complexity
     O(1) space complexity
    */
    public int majorityElementOfficialSolution(final List<Integer> list) {
        int n = list.size();
        int count = 0;
        int result = list.get(0);
        for (Integer i : list) {
            if (count == 0) {
                result = i;
            }
            if (i == result)
                count++;
            else
                count--;
        }
        return result;
    }


    public static void main(String[] args) {
        MajorityElement solution = new MajorityElement();
        System.out.println(solution.majorityElement(Arrays.asList(2, 1, 2)));
        System.out.println(solution.majorityElementOfficialSolution(Arrays.asList(2, 1, 2)));
    }
}
