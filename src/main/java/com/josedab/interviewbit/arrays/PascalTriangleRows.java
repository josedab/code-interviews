package com.josedab.interviewbit.arrays;

import java.util.ArrayList;

/*
 Given numRows, generate the first numRows of Pascal’s triangle.

 Pascal’s triangle : To generate A[C] in row R, sum up A’[C] and A’[C-1] from previous row R - 1.

 Example:

 Given numRows = 5,

 Return

 [
 [1],
 [1,1],
 [1,2,1],
 [1,3,3,1],
 [1,4,6,4,1]
 ]
 */
public class PascalTriangleRows {

    public ArrayList<ArrayList<Integer>> generate(int a) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

        ArrayList<Integer> previousRow = null;
        if (a >= 1) {
            ArrayList<Integer> row = new ArrayList<Integer>();
            row.add(1);
            result.add(row);
            previousRow = row;

        }
        for (int j = 1; j < a; j++) {
            ArrayList<Integer> row = new ArrayList<Integer>();
            row.add(1);
            for (int i = 1; i < previousRow.size(); i++) {
                row.add(previousRow.get(i) + previousRow.get(i - 1));
            }
            row.add(1);

            result.add(row);
            previousRow = row;
        }
        return result;
    }

    public static void main(String[] args) {
        PascalTriangleRows solution = new PascalTriangleRows();
        ArrayList<ArrayList<Integer>> result = solution.generate(3);
        System.out.println(result);
    }
}
