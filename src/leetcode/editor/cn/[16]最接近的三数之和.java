package leetcode.editor.cn;//给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。
//
// 返回这三个数的和。 
//
// 假定每组输入只存在恰好一个解。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,2,1,-4], target = 1
//输出：2
//解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,0,0], target = 1
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 3 <= nums.length <= 1000 
// -1000 <= nums[i] <= 1000 
// -10⁴ <= target <= 10⁴ 
// 
//
// Related Topics 数组 双指针 排序 👍 1241 👎 0


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class ThreeSumCloset16 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int min = 100000;
        for (int l = 0; l < nums.length; l++) {
            for (int r = l + 1; r < nums.length; r++) {
                int t = target - nums[l] - nums[r];
                int kl = r + 1, kr = nums.length - 1;
                if (kl >= nums.length) continue;
                while (kl < kr) {
                    int mid = kl + kr >> 1;
                    if (nums[mid] > t) {
                        kr = mid;
                    } else if (nums[mid] < t) {
                        kl = mid + 1;
                    } else {
                        return target;
                    }
                }
                int sum = nums[l] + nums[r] + nums[kr];
                if (Math.abs(sum - target) < Math.abs(min - target)) min = sum;
            }
        }
        return min;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
