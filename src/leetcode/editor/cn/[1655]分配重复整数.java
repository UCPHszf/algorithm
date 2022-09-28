package leetcode.editor.cn;//给你一个长度为 n 的整数数组 nums ，这个数组中至多有 50 个不同的值。同时你有 m 个顾客的订单 quantity ，其中，整数
//quantity[i] 是第 i 位顾客订单的数目。请你判断是否能将 nums 中的整数分配给这些顾客，且满足： 
//
// 
// 第 i 位顾客 恰好 有 quantity[i] 个整数。 
// 第 i 位顾客拿到的整数都是 相同的 。 
// 每位顾客都满足上述两个要求。 
// 
//
// 如果你可以分配 nums 中的整数满足上面的要求，那么请返回 true ，否则返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3,4], quantity = [2]
//输出：false
//解释：第 0 位顾客没办法得到两个相同的整数。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,3], quantity = [2]
//输出：true
//解释：第 0 位顾客得到 [3,3] 。整数 [1,2] 都没有被使用。
// 
//
// 示例 3： 
//
// 
//输入：nums = [1,1,2,2], quantity = [2,2]
//输出：true
//解释：第 0 位顾客得到 [1,1] ，第 1 位顾客得到 [2,2] 。
// 
//
// 
//
// 提示： 
//
// 
// n == nums.length 
// 1 <= n <= 10⁵ 
// 1 <= nums[i] <= 1000 
// m == quantity.length 
// 1 <= m <= 10 
// 1 <= quantity[i] <= 10⁵ 
// nums 中至多有 50 个不同的数字。 
// 
//
// Related Topics 位运算 数组 动态规划 回溯 状态压缩 👍 45 👎 0


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class allocateInteger {
    public boolean canDistribute(int[] nums, int[] quantity) {
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int n : nums) {
            cnt.put(n, cnt.getOrDefault(n, 0) + 1);
        }
        int[] c = cnt.values().stream().mapToInt(Integer::valueOf).toArray();
        int m = quantity.length, n = c.length;
        int[] sum = new int[1 << m];
        for (int i = 1; i < (1 << m); i++) {
            for (int j = 0; j < m; j++) {
                if ((i & (1 << j)) != 0) {
                    int left = i - (1 << j);
                    sum[i] = sum[left] + quantity[j];
                }
            }
        }

        boolean[][] dp = new boolean[n][1 << m];
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < (1 << m); j++) {
                if (i > 0 && dp[i - 1][j]) {
                    dp[i][j] = true;
                    continue;
                }
                for (int s = j; s != 0; s = ((s - 1) & j)) {
                    int prev = j - s;
                    boolean last = (i == 0) ? (prev == 0) : dp[i - 1][prev];
                    boolean need = sum[s] <= c[i];
                    if (last && need) {
                        dp[i][j] = true;
                        break;
                    }
                }
            }
        }
        return dp[n - 1][(1 << m) - 1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
