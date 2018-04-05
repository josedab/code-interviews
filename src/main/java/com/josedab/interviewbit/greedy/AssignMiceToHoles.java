package com.josedab.interviewbit.greedy;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * There are N Mice and N holes are placed in a straight line.
 Each hole can accomodate only 1 mouse.
 A mouse can stay at his position, move one step right from x to x + 1, or move one step left from x to x − 1. Any of these moves consumes 1 minute.
 Assign mice to holes so that the time when the last mouse gets inside a hole is minimized.

 Example:

 positions of mice are:
 4 -4 2
 positions of holes are:
 4 0 5

 Assign mouse at position x=4 to hole at position x=4 : Time taken is 0 minutes
 Assign mouse at position x=-4 to hole at position x=0 : Time taken is 4 minutes
 Assign mouse at position x=2 to hole at position x=5 : Time taken is 3 minutes
 After 4 minutes all of the mice are in the holes.

 Since, there is no combination possible where the last mouse's time is less than 4,
 answer = 4.
 Input:

 A :  list of positions of mice
 B :  list of positions of holes
 Output:

 single integer value
 NOTE: The final answer will fit in a 32 bit signed integer.
 */
public class AssignMiceToHoles {
    public int mice(List<Integer> micePositions, List<Integer> holePositions) {
        Collections.sort(micePositions);
        Collections.sort(holePositions);

        int result = 0;
        for (int i = 0; i < micePositions.size(); i++) {
            result = Math.max(result, Math.abs(micePositions.get(i) - holePositions.get(i)));
        }
        return result;
    }

    public static void main(String[] args) {
        AssignMiceToHoles solution = new AssignMiceToHoles();
        List<Integer> micePositions = Arrays.asList(4, -4, 2);
        List<Integer> holePositions = Arrays.asList(4, 0, 5);

        System.out.println(solution.mice(micePositions, holePositions));
    }
}
