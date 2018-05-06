package com.josedab.interviewbit.arrays;

import java.util.Arrays;
import java.util.List;

/**
 * Given an array and a value, remove all the instances of that value in the array.
 * Also return the number of elements left in the array after the operation.
 * It does not matter what is left beyond the expected length.
 * <p>
 * Example:
 * If array A is [4, 1, 1, 2, 1, 3]
 * and value elem is 1,
 * then new length is 3, and A is now [4, 2, 3]
 * Try to do it in less than linear additional space complexity.
 * <p>
 * Note: not sure if this is worth it at least for Java devs. This is just an in-place replacement
 */
public class RemoveElementFromArray {
    public int removeElement(List<Integer> list, int target) {
        int index = 0;
        int length = list.size();
        for (int i = 0; i < list.size(); i++) {
            int element = list.get(i);
            if (element != target) {
                list.set(index, element);
                index++;
            } else {
                length--;
            }
        }
        return length;
    }

    public static void main(String[] args) {
        RemoveElementFromArray solution = new RemoveElementFromArray();
        List<Integer> problem = Arrays.asList(4, 1, 1, 2, 1, 3);
        System.out.println(solution.removeElement(problem, 1));
        System.out.println("Only n elements are valid. See previous line to see n");
        System.out.println(problem);
    }

}
