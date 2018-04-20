package com.josedab.interviewbit.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target?
 * Find all unique quadruplets in the array which gives the sum of target.

 Note:
 Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
 The solution set must not contain duplicate quadruplets.
 Example :
 Given array S = {1 0 -1 0 -2 2}, and target = 0
 A solution set is:

 (-2, -1, 1, 2)
 (-2,  0, 0, 2)
 (-1,  0, 0, 1)
 Also make sure that the solution set is lexicographically sorted.
 Solution[i] < Solution[j] iff Solution[i][0] < Solution[j][0] OR (Solution[i][0] == Solution[j][0]
 AND ... Solution[i][k] < Solution[j][k])


 Note:
 Solution based on each of the results being values of the array that can have same indexes

 */
public class FourSumExtension {
    public ArrayList<ArrayList<Integer>> fourSum(List<Integer> list, int target) {
        Collections.sort(list);
        Map<Integer, List<Pair>> map = new HashMap<Integer, List<Pair>>();
        Set<ArrayList<Integer>> setOfResults = new TreeSet<ArrayList<Integer>>(
                (ArrayList<Integer> o1, ArrayList<Integer> o2) -> {

                    int result = 0;
                    for (int i = 0; i < o1.size(); i++) {
                        result = o1.get(i).compareTo(o2.get(i));
                        if (result != 0) {
                            break;
                        }
                    }
                    return result;
                });

        for (int i = 0; i < list.size(); i++) {
            for (int j = i; j < list.size(); j++) {
                int value = target - list.get(i) - list.get(j);
                List<Pair> pairs = map.get(value);
                if (pairs == null) {
                    pairs = new LinkedList<>();
                    map.put(value, pairs);
                }
                pairs.add(new Pair(list.get(i), list.get(j)));
            }
        }

        for (int i = 0; i < list.size(); i++) {
            for (int j = i; j < list.size(); j++) {
                int value = list.get(i) + list.get(j);
                List<Pair> pairs = map.get(value);
                if (pairs != null) {
                    Pair currentPair = new Pair(list.get(i), list.get(j));
                    for (Pair pair : pairs) {
                        setOfResults.add(mergePairs(pair, currentPair));
                    }
                }
            }
        }

        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        for (ArrayList<Integer> result : setOfResults) {
            results.add(result);
        }
        return results;

    }

    private ArrayList<Integer> mergePairs(Pair pairOne, Pair pairTwo) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        result.add(pairOne.getI());
        result.add(pairOne.getJ());
        result.add(pairTwo.getI());
        result.add(pairTwo.getJ());
        Collections.sort(result);
        return result;
    }

    class Pair {
        private int i;
        private int j;

        public Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public int getI() {
            return this.i;
        }

        public int getJ() {
            return this.j;
        }
    }

    public static void main(String[] args) {
        FourSumExtension solution = new FourSumExtension();
        List<Integer> problem = Arrays.asList(1, 0, -1, 0, -2, 2);
        System.out.println(solution.fourSum(problem, 0));
    }

}
