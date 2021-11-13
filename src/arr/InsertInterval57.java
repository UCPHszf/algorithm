package arr;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class InsertInterval57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> tmp = new ArrayList<>();
        int k = 0;
        while (k < intervals.length && intervals[k][1] < newInterval[0]) tmp.add(intervals[k++]);
        if (k < intervals.length) {
            newInterval[0] = Math.min(newInterval[0], intervals[k][0]);
            while (k < intervals.length && intervals[k][0] <= newInterval[1]) {
                newInterval[1] = Math.max(newInterval[1], intervals[k++][1]);
            }
        }
        tmp.add(newInterval);
        while (k < intervals.length) tmp.add(intervals[k++]);
        int[][] res = new int[tmp.size()][];
        for (int i = 0; i < tmp.size(); i++) {
            res[i] = tmp.get(i);
        }
        return res;
    }
}
