package arr;

import java.util.*;

public class FindRightInterval436 {
    public int[] findRightInterval(int[][] intervals) {
        Map<Integer, Integer> idx = new HashMap<>();
        int n = intervals.length;
        for (int i = 0; i < n; i++) {
            idx.put(intervals[i][0], i);
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int[] res = new int[intervals.length];
        for (int[] arr : intervals) {
            int l = 0, r = n - 1;
            while (l < r) {
                int mid = l + r >> 1;
                if (intervals[mid][0] >= arr[1]) r = mid;
                else l = mid + 1;
            }
            int cur = idx.get(arr[0]);
            if (intervals[r][0] >= arr[1]) res[cur] = idx.get(intervals[r][0]);
            else res[cur] = -1;
        }
        return res;
    }
}
