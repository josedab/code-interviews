package com.josedab.interviewbit.arrays;

import com.josedab.interviewbit.arrays.intervals.Interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * https://www.interviewbit.com/problems/merge-overlapping-intervals/
 *
 * Given a collection of intervals, merge all overlapping intervals.
 *
 * For example:
 * Given [1,3],[2,6],[8,10],[15,18],
 * return [1,6],[8,10],[15,18].
 *
 * Make sure the returned intervals are sorted.
 */
public class MergeOverlappingArrays {

    public ArrayList<Interval> merge(List<Interval> intervals) {

        // Sort the intervals, we will take advantage of the sorted for merging intervals later
        Collections.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval i1, Interval i2) {
                return i1.start - i2.start;
            }
        });

        ArrayList<Interval> result = new ArrayList<Interval>();
        Interval aux = null;
        for (Interval interval : intervals) {
            if (overlaps(aux, interval)) {
                aux = mergeIntervals(aux, interval);
            } else {
                if (aux != null) {
                    result.add(aux);
                }
                aux = interval;
            }
        }
        if (aux != null) {
            result.add(aux);
        }
        return result;

    }

    private boolean overlaps(Interval interval1, Interval interval2) {
        if (interval1 == null) {
            return false;
        }
        if (interval1.end >= interval2.start) {
            return true;
        } else {
            return false;
        }
    }

    private Interval mergeIntervals(Interval interval1, Interval interval2) {
        int start = Math.min(interval1.start, interval2.start);
        int end = Math.max(interval1.end, interval2.end);
        Interval result = new Interval(start, end);
        return result;
    }

    public static void main(String[] args) {
        MergeOverlappingArrays solution = new MergeOverlappingArrays();

        List<Interval> intervals = Arrays.asList(
                buildInterval(1, 3),
                buildInterval(2, 6),
                buildInterval(8, 10),
                buildInterval(15, 18)
        );


        ArrayList<Interval> result = solution.merge(intervals);
        System.out.println(result);
    }

    private static Interval buildInterval(int start, int end) {
        Interval interval = new Interval(start, end);
        return interval;
    }
}
