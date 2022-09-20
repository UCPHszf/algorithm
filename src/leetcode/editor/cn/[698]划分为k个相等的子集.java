package leetcode.editor.cn;//给定一个整数数组 nums 和一个正整数 k，找出是否有可能把这个数组分成 k 个非空子集，其总和都相等。
//
// 
//
// 示例 1： 
//
// 
//输入： nums = [4, 3, 2, 3, 5, 2, 1], k = 4
//输出： True
//说明： 有可能将其分成 4 个子集（5），（1,4），（2,3），（2,3）等于总和。 
//
// 示例 2: 
//
// 
//输入: nums = [1,2,3,4], k = 3
//输出: false 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= len(nums) <= 16 
// 0 < nums[i] < 10000 
// 每个元素的频率在 [1,4] 范围内 
// 
//
// Related Topics 位运算 记忆化搜索 数组 动态规划 回溯 状态压缩 👍 651 👎 0


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class KEquivalentSubset698 {
    int[] nums;
    boolean[] st;
    int k;

    public boolean canPartitionKSubsets(int[] nums, int k) {
        this.k = k;
        this.nums = nums;
        int n = nums.length;
        st = new boolean[n];
        int sum = 0;
        for (int c : nums) {
            sum += c;
        }
        if (sum % k != 0) {
            return false;
        }
        sum = sum / k;
        Arrays.sort(nums);
        for (int i = 0, j = nums.length - 1; i < j; i++, j--) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        return dfs(0, 0, sum, 0);

    }

    private boolean dfs(int start, int crt, int sum, int cnt) {
        if (cnt == k - 1) {
            return true;
        }
        if (crt == sum) {
            return dfs(0, 0, sum, cnt + 1);
        }
        for (int i = start; i < nums.length; i++) {
            if (st[i]) {
                continue;
            }
            if (crt + nums[i] <= sum) {
                st[i] = true;
                if (dfs(i + 1, crt + nums[i], sum, cnt)) {
                    return true;
                }
                st[i] = false;
            }
            while (i + 1 < nums.length && nums[i + 1] == nums[i]) i++;
            if (crt == 0 || crt + nums[i] == sum) return false;
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
