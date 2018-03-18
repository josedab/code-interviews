package com.josedab.interviewbit.binarySearch;

import java.util.Arrays;
import java.util.List;

/**
 * Created by jbaena on 3/17/18.
 */
public class SortedInsertedPosition {

    public int searchInsert(List<Integer> a, int b) {
        int i = 0;
        int j = a.size() - 1;
        int solution = 0;
        while (i <= j) {
            int middle = (i + j) / 2;
            if (a.get(middle) == b) {
                return middle;
            } else if (a.get(middle) > b) {
                j = middle - 1;
            } else {
                i = middle + 1;
            }
        }
        solution = i;
        return solution;
    }

    public static void main(String[] args) {
        SortedInsertedPosition solution = new SortedInsertedPosition();
        List<Integer> problem = Arrays.asList(1, 3, 5, 6);
        System.out.println(solution.searchInsert(problem, 5));
        System.out.println(solution.searchInsert(problem, 2));
        System.out.println(solution.searchInsert(problem, 7));
        System.out.println(solution.searchInsert(problem, 0));
    }


}
