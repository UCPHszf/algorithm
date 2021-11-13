package search;

public class MaxAreaofIsland695 {

    int res = 0;
    boolean[][] visit;

    public int maxAreaOfIsland(int[][] grid) {
        visit = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!visit[i][j] && grid[i][j] == 1)
                    res = Math.max(res, dfs(grid, i, j));
            }
        }
        return res;
    }

    int dfs(int[][] grid, int x, int y) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length
                || grid[x][y] == 0 || visit[x][y]) return 0;
        visit[x][y] = true;
        return 1 + dfs(grid, x - 1, y) + dfs(grid, x + 1, y)
                + dfs(grid, x, y - 1) + dfs(grid, x, y + 1);
    }
}
