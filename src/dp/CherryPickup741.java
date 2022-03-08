package dp;

import java.util.Arrays;

public class CherryPickup741 {

    final int N = 55;

    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int[][][] f = new int[N][N][2 * N];
        for (int[][] grids : f) {
            for (int[] row : grids) {
                Arrays.fill(row, -1);
            }
        }
        f[1][1][2] = grid[0][0];
        for (int k = 3; k <= n * 2; k++) {

        }
        return 0;
    }
}
