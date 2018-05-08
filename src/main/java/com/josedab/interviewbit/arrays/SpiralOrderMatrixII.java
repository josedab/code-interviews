package com.josedab.interviewbit.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

 Example:

 Given n = 3,

 You should return the following matrix:

 [
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
 ]
 */
public class SpiralOrderMatrixII {
    public List<List<Integer>> generateMatrix(int n) {
        List<List<Integer>> result = new ArrayList<>();

        // Allocation in memory of the matrix
        for (int i = 0; i < n; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                row.add(0);
            }
            result.add(row);
        }

        int[] coordinate = {n / 2, (n - 1) / 2};
        int currentElement = n * n;
        int direction = (n & 1) == 0 ? 0 : 2;
        result.get(coordinate[0]).set(coordinate[1], currentElement--);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < (i < n - 1 ? 2 : 3); j++) {
                for (int step = 0; step < i; step++) {
                    move(coordinate, direction);
                    result.get(coordinate[0]).set(coordinate[1], currentElement--);
                }
                direction = (direction + 1) % 4; // turn
            }
        }
        return result;
    }

    private void move(int[] coordinate, int dir) {
        switch (dir) {
            case 0:
                coordinate[1]++;
                break; // right
            case 1:
                coordinate[0]--;
                break; // up
            case 2:
                coordinate[1]--;
                break; // left
            case 3:
                coordinate[0]++;
                break; // down
        }
    }

    public static void main(String []args){
        SpiralOrderMatrixII solution = new SpiralOrderMatrixII();
        System.out.println(solution.generateMatrix(3));
    }
}
