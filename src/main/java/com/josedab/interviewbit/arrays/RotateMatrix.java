package com.josedab.interviewbit.arrays;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * You are given an n x n 2D matrix representing an image.

 Rotate the image by 90 degrees (clockwise).

 You need to do this in place.

 Note that if you end up using an additional array, you will only receive partial score.

 Example:

 If the array is

 [
 [1, 2],
 [3, 4]
 ]
 Then the rotated array becomes:

 [
 [3, 1],
 [4, 2]
 ]
 */
public class RotateMatrix {

    public void rotate(ArrayList<ArrayList<Integer>> a) {
        int rows = a.size();
        int columns = a.get(0).size();

        // Mirror primary diagonal
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < i; j++) {
                if (i != j) {
                    Integer aux = a.get(i).get(j);
                    a.get(i).set(j, a.get(j).get(i));
                    a.get(j).set(i, aux);
                }

            }
        }

        // Mirror horizontal
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < (columns / 2); j++) {
                Integer aux = a.get(i).get(j);
                a.get(i).set(j, a.get(i).get(columns - 1 - j));
                a.get(i).set(columns - 1 - j, aux);
            }
        }


    }

    public static void main(String[] args) {
        RotateMatrix solution = new RotateMatrix();


        ArrayList<ArrayList<Integer>> matrix = new ArrayList<ArrayList<Integer>>();
        matrix.add(new ArrayList<Integer>(Arrays.asList(1, 2)));
        matrix.add(new ArrayList<Integer>(Arrays.asList(3, 4)));


        /* Second example
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<ArrayList<Integer>>();
        matrix.add(new ArrayList<Integer>(Arrays.asList(1, 2, 3)));
        matrix.add(new ArrayList<Integer>(Arrays.asList(4,5,6)));
        matrix.add(new ArrayList<Integer>(Arrays.asList(7,8,9)));
        */

        solution.rotate(matrix);

        System.out.println(matrix);
    }
}
