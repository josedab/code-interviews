package com.josedab.interviewbit.hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.

 Sample Input :

 (1, 1)
 (2, 2)
 Sample Output :

 2
 You will be give 2 arrays X and Y. Each point is represented by (X[i], Y[i])

 =========================================================================
 NOTE: this does not work with overlapping points.
 To review: Does this problem make sense?
 Seems to me it is a group of edge cases to consider rather than algorithmia skills

 Review using
 https://www.interviewbit.com/problems/points-on-the-straight-line/
 https://www.geeksforgeeks.org/count-maximum-points-on-same-line/

 Official solution: {@link PointsOnTheStraightLineOfficial}
 */
public class PointsOnTheStraightLine {
    public int maxPoints(List<Integer> a, List<Integer> b) {
        int result = 0;
        if (a.size() == 1) {
            result = 1;
        }

        Map<Pair, Integer> freqIncline = new HashMap<>();
        for (int i = 0; i < a.size() - 1; i++) {
            for (int j = i + 1; j < a.size(); j++) {
                int x = Math.abs(a.get(j) - a.get(i));
                int y = Math.abs(b.get(j) - b.get(i));
                int gcd = gcd(x, y);
                Pair pair = new Pair(x / gcd, y / gcd);

                int frequencyInclination = 1;
                if (freqIncline.containsKey(pair)) {
                    frequencyInclination = freqIncline.get(pair) + 1;
                }
                freqIncline.put(pair, frequencyInclination);
                result = Math.max(result, frequencyInclination);
            }

        }
        return result;
    }

    private int gcd(int a, int b) {
        if (a == 0 && b == 0) return 1;
        if (a == 0) return b;
        if (b == 0) return a;
        if (a < 0) return gcd(-1 * a, b);
        if (b < 0) return gcd(a, -1 * b);
        if (a > b) return gcd(b, a);
        return gcd(b % a, a);
    }

    public class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int hashCode() {
            return Objects.hash(x, y);
        }

        @Override
        public boolean equals(Object o) {

            if (o == this) {
                return true;
            }
            if (!(o instanceof Pair)) {
                return false;
            }
            Pair c = (Pair) o;
            return Integer.compare(x, c.x) == 0
                    && Double.compare(y, c.y) == 0;
        }
    }

    public static void main(String[] args) {
        PointsOnTheStraightLine solution = new PointsOnTheStraightLine();
        System.out.print(solution.maxPoints(
                Arrays.asList(0, 1, -1),
                Arrays.asList(0, 1, -1)
        ));
    }
}
