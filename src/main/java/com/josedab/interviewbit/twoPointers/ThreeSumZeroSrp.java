package com.josedab.interviewbit.twoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0?
 Find all unique triplets in the array which gives the sum of zero.

 Note:

 Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
 The solution set must not contain duplicate triplets. For example, given array S = {-1 0 1 2 -1 -4}, A solution set is:
 (-1, 0, 1)
 (-1, -1, 2)
 */
public class ThreeSumZeroSrp {
    public ArrayList<ArrayList<Integer>> threeSumZero(List<Integer> l) {
        Collections.sort(l);

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        Set<Tuple> set = new HashSet<>();
        for (int i = 0; i < l.size() - 2; i++) {
            int iValue = l.get(i);
            int j = i + 1;
            int k = l.size() - 1;
            while (j < k) {
                int sum = iValue + l.get(j) + l.get(k);
                if (sum == 0) {
                    Tuple potentialResult = new Tuple(iValue, l.get(j), l.get(k));
                    if (!set.contains(potentialResult)) {
                        result.add(potentialResult.getResultFromValues());
                        set.add(potentialResult);
                    }
                    j++;
                    k--;
                } else if (sum < 0) {
                    j++;
                } else {
                    k--;
                }
            }
        }

        return result;
    }

    class Tuple {
        public int i, j, k;

        public Tuple(int i, int j, int k) {
            this.i = i;
            this.j = j;
            this.k = k;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }

            if (!(obj instanceof Tuple)) {
                return false;
            }

            Tuple t = (Tuple) obj;
            return this.i == t.i && this.j == t.j && this.k == t.k;
        }

        public int hashCode() {
            return Objects.hash(i, j, k);
        }

        public ArrayList<Integer> getResultFromValues() {
            ArrayList<Integer> result = new ArrayList<>();
            result.add(this.i);
            result.add(this.j);
            result.add(this.k);
            return result;
        }
    }

    public static void main(String[] args) {
        ThreeSumZeroSrp solution = new ThreeSumZeroSrp();
        System.out.println(
                solution.threeSumZero(
                        Arrays.asList(1, -4, 0, 0, 5, -5, 1, 0, -2, 4, -4, 1, -1, -4, 3, 4, -1, -1, -3)));
    }
}
