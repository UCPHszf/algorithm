package design;

public class RangeSumQuery2DImmutable304 {

    int[][] sum;

    public RangeSumQuery2DImmutable304(int[][] matrix) {
        sum = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (j == 0) {
                    sum[i][j] = matrix[i][j];
                } else {
                    sum[i][j] = matrix[i][j] + sum[i][j - 1];
                }
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int res = 0;
        for (int i = row1; i <= row2; i++) {
            res += col1 > 0 ? sum[i][col2] - sum[i][col1 - 1] : sum[i][col2];
        }
        return res;
    }

}
