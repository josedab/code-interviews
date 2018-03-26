package com.josedab.interviewbit.hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
 * <p>
 * Sample Input :
 * <p>
 * (1, 1)
 * (2, 2)
 * Sample Output :
 * <p>
 * 2
 * You will be give 2 arrays X and Y. Each point is represented by (X[i], Y[i])
 * <p>
 * <p>
 * =========================================================================
 * NOTE: this is the official solution
 * The implemented based on requirements is on {@link PointsOnTheStraightLine}
 */
public class PointsOnTheStraightLineOfficial {
    private HashMap<Double, Integer> hashMap;

    public int maxPoints(List<Integer> A, List<Integer> B) {

        hashMap = new HashMap<>();

        if (A == null || B == null)
            return -1;

        if (A.size() == 0)
            return 0;

        int n = A.size();
        int x1, y1, x2, y2;
        int val;
        int max = 0;

        for (int i = 0; i < n; i++) {

            x1 = A.get(i);
            y1 = B.get(i);
            hashMap.clear();

            for (int j = 0; j < n; j++) {

                if (i == j)
                    continue;

                x2 = A.get(j);
                y2 = B.get(j);

                double slope = y2 - y1;
                int den = x2 - x1;

                if (den == 0)
                    slope = Double.POSITIVE_INFINITY;
                else
                    slope = slope / den;

                val = 1;

                if (hashMap.containsKey(slope)) {
                    val = hashMap.get(slope) + 1;
                }
                hashMap.put(slope, val);

            }

            for (Map.Entry<Double, Integer> entry : hashMap.entrySet()) {
                val = entry.getValue();
                max = Math.max(max, val);
            }
        }

        return max + 1;
    }

    public static void main(String[] args) {
        PointsOnTheStraightLineOfficial solution = new PointsOnTheStraightLineOfficial();
        System.out.print(solution.maxPoints(
                Arrays.asList(0, 1, -1),
                Arrays.asList(0, 1, -1)
        ));
    }
}
