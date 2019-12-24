package codewars.java;

import java.util.Arrays;

public class Interval {
    public static int sumIntervals(int[][] intervals) {
        if(intervals == null) return 0;
        Arrays.sort(intervals, (o1, o2) -> {
            int i = Integer.compare(o1[0], o2[0]);
            if(i == 0) return Integer.compare(o2[1], o2[1]);
            return i;
        });
        int sum = 0;
        int i = 0;
        while(i < intervals.length) {
            int start = i;
            int maxPos = intervals[start][1];
            while(i + 1 < intervals.length) {
                if(intervals[i + 1][0] < maxPos) {
                    if(intervals[i + 1][1] > maxPos) maxPos = intervals[i + 1][1];
                    i++;
                } else {
                    break;
                }
            }
            int end = i;
            sum += (maxPos - intervals[start][0]);
            i++;
        }
        return sum;
    }
}
