package com.josedab.interviewbit.arrays;

import java.util.Arrays;
import java.util.List;

/**
 * Remove duplicates from Sorted Array
 Given a sorted array, remove the duplicates in place such that each element appears only once and return the new length.

 Note that even though we want you to return the new length, make sure to change the original array as well in place

 Do not allocate extra space for another array, you must do this in place with constant memory.

 Example:
 Given input array A = [1,1,2],
 Your function should return length = 2, and A is now [1,2].

 * Note: not sure if this is worth it at least for Java devs. This is just an in-place replacement
 */
public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(List<Integer> list) {

        Integer previous = null;
        int index = 0;
        for(int i=0;i<list.size();i++){
            Integer current = list.get(i);
            if(previous==null || previous.intValue() != current.intValue()){
                list.set(index, current);
                index++;
            }
            previous = current;
        }
        return index;
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArray solution = new RemoveDuplicatesFromSortedArray();
        List<Integer> problem = Arrays.asList(1, 1, 2);
        System.out.println(solution.removeDuplicates(problem));
        System.out.println("Only n elements are valid. See previous line to see n");
        System.out.println(problem);
    }

}
