package com.josedab.interviewbit.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a collection of numbers, return all possible permutations.

 Example:

 [1,2,3] will have the following permutations:

 [1,2,3]
 [1,3,2]
 [2,1,3]
 [2,3,1]
 [3,1,2]
 [3,2,1]
 NOTE
 No two entries in the permutation sequence should be the same.
 For the purpose of this problem, assume that all the numbers in the collection are unique.
 */
public class Permutations {
    public ArrayList<ArrayList<Integer>> permute(List<Integer> A) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<>();
        ArrayList<Integer> partialResults = new ArrayList<>();
        permuteAux(A, partialResults, results);
        return results;
    }

    // Solution with generation/removal of the candidates
    private void permuteAux(List<Integer> candidates,
                            ArrayList<Integer> partialResults,
                            ArrayList<ArrayList<Integer>> results) {

        if (candidates.size() == 0) {
            results.add(new ArrayList<>(partialResults));
        } else {
            for (int i = 0; i < candidates.size(); i++) {
                Integer candidate = candidates.get(i);
                candidates.remove(i);

                partialResults.add(candidate);
                permuteAux(candidates, partialResults, results);
                partialResults.remove(partialResults.size() - 1);

                candidates.add(i, candidate);
            }
        }
    }

    // Alternative solution searching for candidates used
    private void permuteAuxV2(List<Integer> candidates,
                              ArrayList<Integer> partialResults,
                              ArrayList<ArrayList<Integer>> results) {

        if (partialResults.size() == candidates.size()) {
            results.add(new ArrayList<>(partialResults));
        } else {
            for (int i = 0; i < candidates.size(); i++) {
                Integer candidate = candidates.get(i);
                if (!partialResults.contains(candidate)) {
                    partialResults.add(candidate);
                    permuteAux(candidates, partialResults, results);
                    partialResults.remove(partialResults.size() - 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        Permutations permutations = new Permutations();
        System.out.println(permutations.permute(new LinkedList<>(Arrays.asList(1, 2, 3))));
    }

}
