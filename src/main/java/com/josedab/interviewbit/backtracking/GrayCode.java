package com.josedab.interviewbit.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * The gray code is a binary numeral system where two successive values differ in only one bit.

 Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.

 For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:

 00 - 0
 01 - 1
 11 - 3
 10 - 2
 There might be multiple gray code sequences possible for a given n.
 Return any such sequence.
 */
public class GrayCode {
    public ArrayList<Integer> grayCode(int a) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        List<String> partialResults = new LinkedList<String>();
        grayCodeAux(a, partialResults, result);
        return result;
    }

    private void grayCodeAux(int numberOfBitsLeft, List<String> partialResults, ArrayList<Integer> result) {
        if (numberOfBitsLeft == 0) {
            for (String partialResult : partialResults) {
                result.add(Integer.parseInt(partialResult, 2));
            }
        } else {
            //Creation of candidates
            List<String> partialResultsWithOneBitMore = new LinkedList<String>();
            if (partialResults.isEmpty()) {
                partialResultsWithOneBitMore.add("0");
                partialResultsWithOneBitMore.add("1");
            } else {
                for (int i = 0; i < partialResults.size(); i++) {
                    String partialResult = partialResults.get(i);
                    partialResultsWithOneBitMore.add("0" + partialResult);
                }
                for (int i = (partialResults.size() - 1); i >= 0; i--) {
                    String partialResult = partialResults.get(i);
                    partialResultsWithOneBitMore.add("1" + partialResult);
                }
            }
            grayCodeAux(numberOfBitsLeft - 1, partialResultsWithOneBitMore, result);
        }
    }

    public static void main(String[] args) {
        GrayCode solution = new GrayCode();
        System.out.println(solution.grayCode(3));
    }
}
