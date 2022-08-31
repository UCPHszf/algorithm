package search;

public class MinimumNumberofFlipstoConvertBinaryMatrixtoZeroMatrix1284 {
    public int minFlips(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[] dx = {-1, 0, 1, 0, 0}, dy = {0, 1, 0, -1, 0};
        int res = -1;
        for (int i = 0; i < 1 << m * n; i++) {
            int[][] s = mat;
            for (int j = 0; j < n * m; j++) {

            }
        }

        return 0;
    }
}
