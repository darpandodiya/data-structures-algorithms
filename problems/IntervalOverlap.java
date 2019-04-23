package problems;


import java.util.Arrays;
import java.util.Comparator;

/**
 * Given two intevals, check whether they overlap or not.
 *
 * (0, 3), (5,10) - They overlap - return true
 *
 * (1, 5), (7,10) - They do not overlap - return false
 */

class Interval {
    int start;
    int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

public class IntervalOverlap {

    static void sortIntervals(Interval[] intervals) {
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval inter1, Interval inter2) {
                return inter1.start < inter2.start ? 1 : 0;
            }
        });
    }

    static boolean isOverlap(Interval[] intervals) {
        sortIntervals(intervals);

        for(int index = 1; index < intervals.length; index++) {
            if(intervals[index].start <= intervals[index-1].end) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Interval inter1 = new Interval(0, 0);
        Interval inter2 = new Interval(0, 0);

        System.out.println(isOverlap(new Interval[]{inter1, inter2}));
    }
}
