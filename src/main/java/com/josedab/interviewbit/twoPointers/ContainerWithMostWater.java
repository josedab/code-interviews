package com.josedab.interviewbit.twoPointers;

import java.util.Arrays;
import java.util.List;

/**
 * Given n non-negative integers a1, a2, ..., an,
 where each represents a point at coordinate (i, ai).
 'n' vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).

 Find two lines, which together with x-axis forms a container, such that the container contains the most water.

 Your program should return an integer which corresponds to the maximum area of water that can be contained ( Yes, we know maximum area instead of maximum volume sounds weird. But this is 2D plane we are working with for simplicity ).

 Note: You may not slant the container.
 Example :

 Input : [1, 5, 4, 3]
 Output : 6

 Explanation : 5 and 3 are distance 2 apart. So size of the base = 2. Height of container = min(5, 3) = 3.
 So total area = 3 * 2 = 6
 */
public class ContainerWithMostWater {

    // O(n)
    public int maxArea(List<Integer> A) {
        int solution = 0;

        int i = 0;
        int j = A.size() - 1;
        while (i < j) {
            int base = j - i;
            int height = Math.min(A.get(i), A.get(j));
            solution = Math.max(solution, base * height);
            if (A.get(i) < A.get(j)) {
                i++;
            } else {
                j--;
            }
        }

        return solution;
    }

    //O(n^2)
    public int maxAreaV2(List<Integer> A) {
        int solution = 0;
        for (int i = 0; i < A.size() - 1; i++) {
            for (int j = i + 1; j < A.size(); j++) {
                int base = j - i;
                int height = Math.min(A.get(i), A.get(j));
                solution = Math.max(solution, base * height);
            }
        }
        return solution;
    }

    public static void main(String []args){
        ContainerWithMostWater solution = new ContainerWithMostWater();
        System.out.println(solution.maxArea(Arrays.asList(1,5,4,3)));
        System.out.println(solution.maxAreaV2(Arrays.asList(1,5,4,3)));
    }
}
