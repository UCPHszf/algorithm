package leetcode.editor.cn;//给定包含多个点的集合，从其中取三个点组成三角形，返回能组成的最大三角形的面积。
//
// 
//示例:
//输入: points = [[0,0],[0,1],[1,0],[0,2],[2,0]]
//输出: 2
//解释: 
//这五个点如下图所示。组成的橙色三角形是最大的，面积为2。
// 
//
// 
//
// 注意: 
//
// 
// 3 <= points.length <= 50. 
// 不存在重复的点。 
// -50 <= points[i][j] <= 50. 
// 结果误差值在 10^-6 以内都认为是正确答案。 
// 
//
// Related Topics 几何 数组 数学 👍 174 👎 0

// S = \frac {1} {2} \ast |x_1 * y_2 + x_2 * y_3 + x_3 * y_1 - x_2 * y_1 - x_3 * y_2 - x_1 * y_3|

//leetcode submit region begin(Prohibit modification and deletion)
class LargestTriangleArea812 {
    public double largestTriangleArea(int[][] points) {
        double max = 0;
        for (int i = 0; i < points.length; i++) {
            int[] a = points[i];
            for (int j = i + 1; j < points.length; j++) {
                int[] b = points[j];
                for (int k = j + 1; k < points.length; k++) {
                    int[] c = points[k];
                    if (isTriangle(a, b, c)) {
                        double dist_a_b = Math.sqrt(Math.pow(a[0] - b[0], 2) + Math.pow(a[1] - b[1], 2));
                        double dist_c_to_line_ab;
                        if (b[0] == a[0]) {
                            dist_c_to_line_ab = Math.abs(c[0] - b[0]);
                        } else {
                            double slope = (b[1] - a[1]) * 1.0 / (b[0] - a[0]);
                            double intercept = b[1] - slope * b[0];
                            dist_c_to_line_ab = (Math.abs(slope * c[0] - c[1] + intercept))
                                    / (Math.sqrt(1 + slope * slope));
                        }
                        double area = (dist_a_b * dist_c_to_line_ab) / 2.0;
                        max = Math.max(max, area);
                    }
                }
            }
        }
        return max;
    }

    public boolean isTriangle(int[] a, int[] b, int[] c) {
        if ((a[0] == b[0] && a[0] == c[0]) || (a[1] == b[1] && a[1] == c[1])) {
            return false;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
