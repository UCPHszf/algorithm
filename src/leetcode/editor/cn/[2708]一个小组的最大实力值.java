import java.util.Arrays;

class Solution {
    public long maxStrength(int[] nums) {
        if (nums.length == 1) return nums[0];
        Arrays.sort(nums);
        int n = nums.length;
        long res = 1;
        boolean flag = false;
        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] > 0) {
                res *= nums[i];
                flag = true;
            } else {
                break;
            }
        }
        for (int i = 0; i < n; ) {
            if (nums[i] > 0 || i + 1 >= n || nums[i + 1] > 0) break;
            long ne = nums[i + 1];
            if (ne < 0) {
                res *= nums[i] * ne;
                i += 2;
            } else {
                if (!flag && res == 1) return 0;
                else break;
            }
        }
        return res;
    }
}
