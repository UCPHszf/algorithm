package dp;

public class UniquePathsIII980 {
    int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
    int m, n, k;
    int[][] g;

    public int dfs(int x, int y) {
        if (g[x][y] == 2) {
            if (k == 0) return 1;
            return 0;
        }
        g[x][y] = -1;
        k--;
        int res = 0;
        for (int i = 0; i < 4; i++) {
            int a = x + dx[i], b = y + dy[i];
            if (a >= 0 && a < m && b >= 0 && b < n && g[a][b] != -1)
                res += dfs(a, b);
        }
        g[x][y] = 0;
        k++;
        return res;
    }


    public int uniquePathsIII(int[][] grid) {
        g = grid;
        m = grid.length;
        n = grid[0].length;
        k = 0;
        int sx=0, sy=0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (g[i][j] == 0) k++;
                if (g[i][j] == 1) {
                    sx = i;
                    sy = j;
                    k++;
                }
            }
        }
        return dfs(sx, sy);
    }
}
