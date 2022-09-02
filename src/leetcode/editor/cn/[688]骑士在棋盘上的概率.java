package leetcode.editor.cn;//在一个 n x n 的国际象棋棋盘上，一个骑士从单元格 (row, column) 开始，并尝试进行 k 次移动。行和列是 从 0 开始 的，所以左上单元格
//是 (0,0) ，右下单元格是 (n - 1, n - 1) 。 
//
// 象棋骑士有8种可能的走法，如下图所示。每次移动在基本方向上是两个单元格，然后在正交方向上是一个单元格。 
//
// 
//
// 每次骑士要移动时，它都会随机从8种可能的移动中选择一种(即使棋子会离开棋盘)，然后移动到那里。 
//
// 骑士继续移动，直到它走了 k 步或离开了棋盘。 
//
// 返回 骑士在棋盘停止移动后仍留在棋盘上的概率 。 
//
// 
//
// 示例 1： 
//
// 
//输入: n = 3, k = 2, row = 0, column = 0
//输出: 0.0625
//解释: 有两步(到(1,2)，(2,1))可以让骑士留在棋盘上。
//在每一个位置上，也有两种移动可以让骑士留在棋盘上。
//骑士留在棋盘上的总概率是0.0625。
// 
//
// 示例 2： 
//
// 
//输入: n = 1, k = 0, row = 0, column = 0
//输出: 1.00000
// 
//
// 
//
// 提示: 
//
// 
// 1 <= n <= 25 
// 0 <= k <= 100 
// 0 <= row, column <= n 
// 
//
// Related Topics 动态规划 👍 302 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class knightProbability688 {
    int[] dx = new int[]{1, 1, -1, -1, 2, 2, -2, -2};
    int[] dy = new int[]{2, -2, 2, -2, 1, -1, 1, -1};
    double[][][] dp;

    public double knightProbability(int n, int K, int row, int column) {
        int numOfMoveDirection = dx.length;
        dp = new double[n][n][K + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j][K] = 1;
            }
        }
        for (int k = K - 1; k >= 0; k--) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    for (int d = 0; d < 8; d++) {
                        int newX = i + dx[d], newY = j + dy[d];
                        if (newX >= 0 && newX < n && newY >= 0 && newY < n) {
                            dp[i][j][k] += dp[newX][newY][k + 1] / 8;
                        }
                    }
                }
            }
        }
        return dp[row][column][0];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
