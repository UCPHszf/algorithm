package Math;

public class SurfaceAreaof3DShapes892 {
    public int surfaceArea(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //底面积
                if (grid[i][j] != 0) res += 2;
                //左侧面积
                if (j - 1 < 0) res += grid[i][j];
                else {
                    if (grid[i][j] > grid[i][j - 1]) res += grid[i][j] - grid[i][j - 1];
                }
                //右侧面积
                if (j + 1 >= n) res += grid[i][j];
                else {
                    if (grid[i][j] > grid[i][j + 1]) res += grid[i][j] - grid[i][j + 1];
                }
                //前方面积
                if(i-1<0)res+=grid[i][j];
                else{
                    if(grid[i][j]>grid[i-1][j])res+=grid[i][j]-grid[i-1][j];
                }
                //后方面积
                if(i+1>=n)res+=grid[i][j];
                else{
                    if(grid[i][j]>grid[i+1][j])res+=grid[i][j]-grid[i+1][j];
                }
            }
        }
        return res;
    }
}
