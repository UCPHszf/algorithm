package Math;

public class RangeAdditionII598 {
    public int maxCount(int m, int n, int[][] ops) {
        int max_X = m;
        int max_Y = n;
        for (int[] op : ops) {
            if (op[0] < max_X) max_X = op[0];
            if (op[1] < max_Y) max_Y = op[1];
        }
        return max_X * max_Y;
    }
}
