package com.josedab.interviewbit.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given an array A of integers, find the index of values that satisfy A + B = C + D, where A,B,C & D are integers values in the array

 Note:

 1) Return the indices `A1 B1 C1 D1`, so that
 A[A1] + A[B1] = A[C1] + A[D1]
 A1 < B1, C1 < D1
 A1 < C1, B1 != D1, B1 != C1

 2) If there are more than one solutions,
 then return the tuple of values which are lexicographical smallest.

 Assume we have two solutions
 S1 : A1 B1 C1 D1 ( these are values of indices int the array )
 S2 : A2 B2 C2 D2

 S1 is lexicographically smaller than S2 iff
 A1 < A2 OR
 A1 = A2 AND B1 < B2 OR
 A1 = A2 AND B1 = B2 AND C1 < C2 OR
 A1 = A2 AND B1 = B2 AND C1 = C2 AND D1 < D2
 Example:

 Input: [3, 4, 7, 1, 2, 9, 8]
 Output: [0, 2, 3, 5] (O index)
 If no solution is possible, return an empty list.
 */
public class Equal {
    public ArrayList<Integer> equal(List<Integer> A) {
        ArrayList<Integer> result = null;
        Map<Integer, ArrayList<Integer>> sums = new HashMap<Integer, ArrayList<Integer>>();
        for (int i = 0; i < (A.size() - 1); i++) {
            for (int j = i + 1; j < A.size(); j++) {
                int sum = A.get(i) + A.get(j);
                if (!sums.containsKey(sum)) {
                    ArrayList<Integer> pair = new ArrayList<Integer>();
                    pair.add(i);
                    pair.add(j);
                    sums.put(sum, pair);
                } else {
                    ArrayList<Integer> pair = sums.get(sum);
                    if (!pair.contains(i) && !pair.contains(j)) {

                        ArrayList<Integer> candidate = new ArrayList<Integer>();
                        candidate.addAll(sums.get(sum));
                        candidate.add(i);
                        candidate.add(j);
                        if (result == null || isResultLowerThanCurrent(result, candidate)) {
                            result = candidate;
                        }
                    }
                }
            }
        }
        return result;
    }

    private boolean isResultLowerThanCurrent(List<Integer> current, List<Integer> candidate) {
        return candidate.get(0) < current.get(0) ||
                candidate.get(0) == current.get(0) && candidate.get(1) < current.get(1) ||
                candidate.get(0) == current.get(0) && candidate.get(1) == current.get(1) && candidate.get(2) < current.get(2) ||
                candidate.get(0) == current.get(0) && candidate.get(1) == current.get(1) && candidate.get(2) == current.get(2) && candidate.get(3) < current.get(3);
    }

    public static void main(String[] args) {
        Equal solution = new Equal();
        System.out.println(solution.equal(Arrays.asList(3, 4, 7, 1, 2, 9, 8)));
    }
}
