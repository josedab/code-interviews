package com.josedab.interviewbit.arrays.intervals;

/**
 * Represents an interval of time
 * Note this class is just used as propsed on the website. No patterns or optimizations.
 */
public class Interval {
    public int start;
    public int end;

    public Interval() {
        start = 0;
        end = 0;
    }

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return "Interval{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}
