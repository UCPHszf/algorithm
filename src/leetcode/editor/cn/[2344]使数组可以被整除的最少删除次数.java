package leetcode.editor.cn;//给你两个正整数数组 nums 和 numsDivide 。你可以从 nums 中删除任意数目的元素。
//
// 请你返回使 nums 中 最小 元素可以整除 numsDivide 中所有元素的 最少 删除次数。如果无法得到这样的元素，返回 -1 。 
//
// 如果 y % x == 0 ，那么我们说整数 x 整除 y 。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [2,3,2,4,3], numsDivide = [9,6,9,3,15]
//输出：2
//解释：
//[2,3,2,4,3] 中最小元素是 2 ，它无法整除 numsDivide 中所有元素。
//我们从 nums 中删除 2 个大小为 2 的元素，得到 nums = [3,4,3] 。
//[3,4,3] 中最小元素为 3 ，它可以整除 numsDivide 中所有元素。
//可以证明 2 是最少删除次数。
// 
//
// 示例 2： 
//
// 输入：nums = [4,3,6], numsDivide = [8,2,6,10]
//输出：-1
//解释：
//我们想 nums 中的最小元素可以整除 numsDivide 中的所有元素。
//没有任何办法可以达到这一目的。 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length, numsDivide.length <= 10⁵ 
// 1 <= nums[i], numsDivide[i] <= 10⁹ 
// 
//
// Related Topics 数组 数学 数论 排序 堆（优先队列） 👍 8 👎 0


import java.util.Arrays;
import java.util.PriorityQueue;

//leetcode submit region begin(Prohibit modification and deletion)
class MinimumDeletionstoMakeArrayDivisible2344 {
    public int minOperations(int[] nums, int[] numsDivide) {
        Arrays.sort(nums);
        PriorityQueue<Integer> q = new PriorityQueue<>((o1, o2) -> o2 - o1);
        int idx = 0;
        for (int i : numsDivide) q.add(i);
        while (!q.isEmpty() && idx < nums.length) {
            int n = q.peek();
            while (idx < nums.length && n % nums[idx] != 0) {
                idx++;
            }
            if (idx == nums.length) {
                return -1;
            }
            if (n % nums[idx] == 0) q.poll();
        }
        return idx;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
