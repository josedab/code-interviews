package com.josedab.interviewbit.twoPointers;

import java.util.Arrays;
import java.util.List;

/**
 * Given an array with n objects colored red, white or blue,
 sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

 Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

 Note: Using library sort function is not allowed.

 Example :

 Input : [0 1 2 0 1 2]
 Modify array so that it becomes : [0 0 1 1 2 2]
 */
public class SortByColor {
    private static final int RED = 0;
    private static final int WHITE = 1;

    public void sortColors(List<Integer> a) {
        int pointer = 0;
        for (int i = 0; i < a.size(); i++) {
            int color = a.get(i);
            if (color == RED) {
                a.set(i, a.get(pointer));
                a.set(pointer, color);
                pointer++;
            }
        }

        for (int i = pointer; i < a.size(); i++) {
            int color = a.get(i);
            if (color == WHITE) {
                a.set(i, a.get(pointer));
                a.set(pointer, color);
                pointer++;
            }
        }
    }

    public static void main(String[] args) {
        SortByColor solution = new SortByColor();
        List<Integer> problem = Arrays.asList(0, 1, 2, 0, 1, 2);
        solution.sortColors(problem);
        System.out.println(problem);
    }
}
