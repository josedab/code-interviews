package com.josedab.interviewbit.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a matrix of m * n elements (m rows, n columns), return all elements of the matrix in spiral order.

 Example:

 Given the following matrix:

 [
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
 ]
 You should return

 [1, 2, 3, 6, 9, 8, 7, 4, 5]
 */
public class SpiralOrderMatrixI {
    public List<Integer> spiralOrder(final List<List<Integer>> matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix.size() == 0) {
            return result;
        }
        int rows = matrix.size();
        int columns = matrix.get(0).size();

        boolean[][] visited = new boolean[rows][columns];
        int[] deltaRow = {0, 1, 0, -1};
        int[] deltaColumn = {1, 0, -1, 0};
        int rowIndex = 0;
        int columnIndex = 0;
        int direction = 0;

        for (int i = 0; i < rows * columns; i++) {

            result.add(matrix.get(rowIndex).get(columnIndex));
            visited[rowIndex][columnIndex] = true;
            int currentRow = rowIndex + deltaRow[direction];
            int currentColumn = columnIndex + deltaColumn[direction];

            if (0 <= currentRow && currentRow < rows &&
                    0 <= currentColumn && currentColumn < columns &&
                    !visited[currentRow][currentColumn]) {
                rowIndex = currentRow;
                columnIndex = currentColumn;
            } else {
                direction = (direction + 1) % 4;
                rowIndex += deltaRow[direction];
                columnIndex += deltaColumn[direction];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        SpiralOrderMatrixI solution = new SpiralOrderMatrixI();
        List<List<Integer>> problem = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5, 6),
                Arrays.asList(7, 8, 9)
        );
        System.out.println(solution.spiralOrder(problem));
    }

}
