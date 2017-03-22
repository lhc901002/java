package com.ctci;

import com.algorithm.Interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Michael on 2/21/17.
 */
public class IntervalScheduling {
    public static List<Interval> maxNonOverlapIntervals(Interval[] intervals) {
        if (intervals == null) {
            return null;
        }
        List<Interval> result = new ArrayList<Interval>();
        if (intervals.length == 0) {
            return result;
        }
        // Sort intervals based on end time
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.end - o2.end;
            }
        });
        result.add(intervals[0]);
        Interval lastInterval = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].start >= lastInterval.end) {
                result.add(intervals[i]);
                lastInterval = intervals[i];
            }
        }
        return result;
    }

    public static int maxWeightOfNonOverlapIntervals(Interval[] intervals) {
        if (intervals == null) {
            return 0;
        }
        if (intervals.length == 0) {
            return 0;
        }
        // Sort intervals based on end time
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.end - o2.end;
            }
        });
        // ps[i] stores interval compatible with task i with largest index that index < i
        int[] ps = new int[intervals.length];
        Arrays.fill(ps, -1);
        // Compute ps[i]
        for (int i = 1; i < intervals.length; i++) {
            for (int j = 0; j < i; j++) {
                if (intervals[j].end <= intervals[i].start) {
                    ps[i] = j;
                }
            }
        }
        // opt[i] stores the optimal result until current interval
        int[] opt = new int[intervals.length];
        opt[0] = intervals[0].end - intervals[0].start;  // opt of first interval is its weight (end - start)
        for (int i = 1; i < intervals.length; i++) {
            if (ps[i] == -1) {
                opt[i] = Math.max(intervals[i].end - intervals[i].start, opt[i - 1]);
            } else {
                opt[i] = Math.max(intervals[i].end - intervals[i].start + opt[ps[i]], opt[i - 1]);
            }
        }
        return opt[opt.length - 1];
    }

    public static List<Interval> maxWeightNonOverlapIntervals(Interval[] intervals) {
        if (intervals == null) {
            return null;
        }
        if (intervals.length == 0) {
            return new ArrayList<Interval>();
        }
        // Sort intervals based on end time
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.end - o2.end;
            }
        });
        // ps[i] stores interval compatible with task i with largest index that index < i
        int[] ps = new int[intervals.length];
        Arrays.fill(ps, -1);
        // Compute ps[i]
        for (int i = 1; i < intervals.length; i++) {
            for (int j = 0; j < i; j++) {
                if (intervals[j].end <= intervals[i].start) {
                    ps[i] = j;
                }
            }
        }
        // opt[i] stores the optimal result until current interval
        int[] opt = new int[intervals.length];
        List<List<Interval>> optIntervals = new ArrayList<List<Interval>>();
        opt[0] = intervals[0].end - intervals[0].start;  // opt of first interval is its weight (end - start)
        List<Interval> subsetInterval = new ArrayList<Interval>();
        subsetInterval.add(intervals[0]);
        optIntervals.add(subsetInterval);
        for (int i = 1; i < intervals.length; i++) {
            subsetInterval = new ArrayList<Interval>();
            if (ps[i] == -1) {
                int weight = intervals[i].end - intervals[i].start;
                if (weight > opt[i - 1]) {
                    opt[i] = weight;
                    subsetInterval.add(intervals[i]);
                } else {
                    opt[i] = opt[i - 1];
                    subsetInterval.addAll(optIntervals.get(i - 1));
                }
            } else {
                int weight = intervals[i].end - intervals[i].start + opt[ps[i]];
                if (weight > opt[i - 1]) {
                    opt[i] = weight;
                    subsetInterval.addAll(optIntervals.get(ps[i]));
                    subsetInterval.add(intervals[i]);
                } else {
                    opt[i] = opt[i - 1];
                    subsetInterval.addAll(optIntervals.get(i - 1));
                }
            }
            optIntervals.add(subsetInterval);
        }
        return optIntervals.get(intervals.length - 1);
    }

    public static void printIntervals(List<Interval> intervals) {
        for (Interval interval : intervals) {
            System.out.print("[" + interval.start + ", " + interval.end + "]");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Interval[] intervals = {new Interval(0, 6), new Interval(1, 4), new Interval(3, 5), new Interval(3, 8),
                new Interval(4, 7), new Interval(5, 9), new Interval(6, 10), new Interval(8, 11)};
        List<Interval> list = maxWeightNonOverlapIntervals(intervals);
        printIntervals(list);
//        int opt = maxWeightOfNonOverlapIntervals(intervals);
//        System.out.println(opt);
    }
}
