package com.josedab.interviewbit.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Given a collection of candidate numbers (C) and a target number (T),
 * find all unique combinations in C where the candidate numbers sums to T.

 Each number in C may only be used once in the combination.

 Note:
 All numbers (including target) will be positive integers.
 Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
 The solution set must not contain duplicate combinations.
 Example :

 Given candidate set 10,1,2,7,6,1,5 and target 8,

 A solution set is:

 [1, 7]
 [1, 2, 5]
 [2, 6]
 [1, 1, 6]
 Warning : DO NOT USE LIBRARY FUNCTION FOR GENERATING COMBINATIONS.
 Example : itertools.combinations in python.
 If you do, we will disqualify your submission retroactively and give you penalty points.
 */
public class CombinationSumII {

    public List<List<Integer>> combinationSum(List<Integer> candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temporalResult = new ArrayList<>();
        Collections.sort(candidates);
        helper(result, temporalResult, 0, target, candidates);
        return result;
    }

    public void helper(List<List<Integer>> result, List<Integer> temporalResult, int start, int target, List<Integer> candidates) {
        if (target == 0) {
            result.add(new ArrayList<>(temporalResult));
            return;
        }
        if (target < 0) {
            return;
        }

        int prev = -1;
        for (int i = start; i < candidates.size(); i++) {
            if (prev != candidates.get(i)) { // each time start from different element
                temporalResult.add(candidates.get(i));
                helper(result, temporalResult, i + 1, target - candidates.get(i), candidates); // and use next element only
                temporalResult.remove(temporalResult.size() - 1);
                prev = candidates.get(i);
            }
        }
    }

    public static void main(String[] args) {
        CombinationSumII solution = new CombinationSumII();
        System.out.println(solution.combinationSum(Arrays.asList(10, 1, 2, 7, 6, 1, 5), 8));
    }
}
