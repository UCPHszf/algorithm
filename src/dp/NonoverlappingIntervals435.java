package dp;

import java.util.Arrays;
import java.util.Comparator;

public class NonoverlappingIntervals435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        //按区间右端点从小到大排序，从左到右选择每个区间，如果该区间和上一个区间没有交集，那么选择该区间
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        int res = 1, right = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= right) {
                res++;
                right = intervals[i][1];
            }
        }
        return intervals.length - res;
    }
}
