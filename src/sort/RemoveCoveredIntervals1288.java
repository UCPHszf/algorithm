package sort;

import java.util.Arrays;
import java.util.Comparator;

public class RemoveCoveredIntervals1288 {
    public int removeCoveredIntervals(int[][] intervals) {
        int res = intervals.length;
        Arrays.sort(intervals, (o1, o2) -> {
            if (o1[1] != o2[1]) {
                return o1[1] - o2[1];
            } else {
                return o2[0] - o1[0];
            }
        });
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= intervals[i - 1][0]) {
                res--;
            }
        }
        return res;
    }
}
