package arr;

public class ReshapetheMatrix566 {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int m = mat.length, n = mat[0].length;
        if (m * n != r * c) return mat;
        else {
            int[][] res = new int[r][c];
            int row = 0, col = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    res[row][col] = mat[i][j];
                    col++;
                    if (col == c) {
                        col = 0;
                        row++;
                    }
                }
            }
            return res;
        }
    }
}
