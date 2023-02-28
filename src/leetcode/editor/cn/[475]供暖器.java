//冬季已经来临。 你的任务是设计一个有固定加热半径的供暖器向所有房屋供暖。 
//
// 在加热器的加热半径范围内的每个房屋都可以获得供暖。 
//
// 现在，给出位于一条水平线上的房屋 houses 和供暖器 heaters 的位置，请你找出并返回可以覆盖所有房屋的最小加热半径。 
//
// 说明：所有供暖器都遵循你的半径标准，加热的半径也一样。 
//
// 
//
// 示例 1: 
//
// 
//输入: houses = [1,2,3], heaters = [2]
//输出: 1
//解释: 仅在位置2上有一个供暖器。如果我们将加热半径设为1，那么所有房屋就都能得到供暖。
// 
//
// 示例 2: 
//
// 
//输入: houses = [1,2,3,4], heaters = [1,4]
//输出: 1
//解释: 在位置1, 4上有两个供暖器。我们需要将加热半径设为1，这样所有房屋就都能得到供暖。
// 
//
// 示例 3： 
//
// 
//输入：houses = [1,5], heaters = [2]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// 1 <= houses.length, heaters.length <= 3 * 10⁴ 
// 1 <= houses[i], heaters[i] <= 10⁹ 
// 
//
// Related Topics 数组 双指针 二分查找 排序 👍 440 👎 0


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        if (heaters.length == 1)
            return Math.max(Math.abs(heaters[0] - houses[0]),
                    Math.abs(heaters[0] - houses[houses.length - 1]));
        int res = 0;
        int n = houses.length;
        int l = 0;
        for (int i = 0; i < n; i++) {
            int pos = houses[i];
            while (l < heaters.length - 2 && heaters[l + 1] < pos) {
                l++;
            }
            int r = l + 1;
            res = Math.max(res, Math.min(Math.abs(heaters[l] - pos), Math.abs(heaters[r] - pos)));
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
