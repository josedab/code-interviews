package com.josedab.interviewbit.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

 The same repeated number may be chosen from C unlimited number of times.

 Note:
 All numbers (including target) will be positive integers.
 Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
 The combinations themselves must be sorted in ascending order.
 CombinationA > CombinationB iff (a1 > b1) OR (a1 = b1 AND a2 > b2) OR … (a1 = b1 AND a2 = b2 AND … ai = bi AND ai+1 > bi+1)
 The solution set must not contain duplicate combinations.
 Example,
 Given candidate set 2,3,6,7 and target 7,
 A solution set is:

 [2, 2, 3]
 [7]

 */
public class CombinationSum {

    public ArrayList<ArrayList<Integer>> combinationSum(List<Integer> A, int B) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> partialResult = new ArrayList<Integer>();
        Set<Integer> elements = new TreeSet<>(A);
        ArrayList<Integer> candidates = new ArrayList<Integer>(elements);
        combinationSumAux(result, 0, candidates, partialResult, B);
        return result;
    }

    private void combinationSumAux(ArrayList<ArrayList<Integer>> result,
                                   int indexStartOfCandidates,
                                   ArrayList<Integer> candidates,
                                   ArrayList<Integer> partialResult,
                                   int B) {

        for (int i = indexStartOfCandidates; i < candidates.size(); i++) {
            Integer candidate = candidates.get(i);
            partialResult.add(candidate);

            if (candidate == B) {
                result.add(new ArrayList(partialResult));
            } else if (candidate < B) {
                combinationSumAux(result, i, candidates, partialResult, B - candidate);
            }
            partialResult.remove(partialResult.size() - 1);

            // Optimization
            if (candidate > B) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        CombinationSum solution = new CombinationSum();
        System.out.println(solution.combinationSum(Arrays.asList(2, 3, 6, 7), 7));
    }
}
