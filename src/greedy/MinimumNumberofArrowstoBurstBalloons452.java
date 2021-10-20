package greedy;

import java.util.Arrays;
import java.util.Comparator;

public class MinimumNumberofArrowstoBurstBalloons452 {

    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(o -> o[0]));
        int res = 0;
        int start = points[0][0], end = points[0][1];
        for (int i = 1; i < points.length; i++) {
            int m = points[i][0], n = points[i][1];
            if (m > end) {
                end = n;
                res++;
            } else {
                end = Math.min(n, end);
            }
            start = m;
        }
        res++;
        return res;
    }
}
