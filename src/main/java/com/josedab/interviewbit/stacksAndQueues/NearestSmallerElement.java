package com.josedab.interviewbit.stacksAndQueues;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Given an array, find the nearest smaller element G[i] for every element A[i] in the array such that the element has an index smaller than i.

 More formally,

 G[i] for an element A[i] = an element A[j] such that
 j is maximum possible AND
 j < i AND
 A[j] < A[i]
 Elements for which no smaller element exist, consider next smaller element as -1.

 Example:

 Input : A : [4, 5, 2, 10, 8]
 Return : [-1, 4, -1, 2, 2]

 Example 2:

 Input : A : [3, 2, 1]
 Return : [-1, -1, -1]
 */
public class NearestSmallerElement {
    public List<Integer> prevSmaller(List<Integer> A) {
        List<Integer> solution = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        for (Integer elem : A) {
            if (stack.isEmpty()) {
                solution.add(-1);
                stack.push(elem);
            } else {
                Integer topOfStack = stack.pop();
                while (topOfStack >= elem && !stack.isEmpty()) {
                    topOfStack = stack.pop();
                }

                if (stack.isEmpty() && topOfStack >= elem) {
                    solution.add(-1);
                } else {
                    solution.add(topOfStack);
                }

                stack.push(topOfStack);
                stack.push(elem);

            }
        }
        return solution;
    }

    public static void main(String[] args) {
        NearestSmallerElement solution = new NearestSmallerElement();
        System.out.println(solution.prevSmaller(Arrays.asList(4, 5, 2, 10, 8)));
    }

}
