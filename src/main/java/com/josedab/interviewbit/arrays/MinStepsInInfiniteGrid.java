package com.josedab.interviewbit.arrays;

import java.util.Arrays;
import java.util.List;

/**
 * You are in an infinite 2D grid where you can move in any of the 8 directions :

 (x,y) to
 (x+1, y),
 (x - 1, y),
 (x, y+1),
 (x, y-1),
 (x-1, y-1),
 (x+1,y+1),
 (x-1,y+1),
 (x+1,y-1)
 You are given a sequence of points and the order in which you need to cover the points.
 Give the minimum number of steps in which you can achieve it. You start from the first point.

 Example :

 Input : [(0, 0), (1, 1), (1, 2)]
 Output : 2
 It takes 1 step to move from (0, 0) to (1, 1). It takes one more step to move from (1, 1) to (1, 2).

 */
public class MinStepsInInfiniteGrid {

    public int coverPoints(List<Integer> xCoordinates, List<Integer> yCoordinates) {
        int sum = 0;
        int x1 = xCoordinates.get(0);
        int y1 = yCoordinates.get(0);
        for (int i = 1; i < xCoordinates.size(); i++) {
            int x2 = xCoordinates.get(i);
            int y2 = yCoordinates.get(i);
            sum += calculateMinSteps(x1, y1, x2, y2);
            x1 = x2;
            y1 = y2;
        }
        return sum;
    }

    private int calculateMinSteps(int x1, int y1, int x2, int y2) {
        int xDifference = Math.abs(x2 - x1);
        int yDifference = Math.abs(y2 - y1);
        return (xDifference < yDifference) ?
                yDifference : xDifference;
    }

    public static void main(String[] args) {
        MinStepsInInfiniteGrid solution = new MinStepsInInfiniteGrid();
        System.out.println(solution.coverPoints(Arrays.asList(0, 1, 1), Arrays.asList(0, 1, 2)));
    }
}
