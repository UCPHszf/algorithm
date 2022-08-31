package dp;

public class MaxSubArray_LCOF42 {

    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        int res = nums[0];
        for (int i = 0; i < nums.length; i++) {
            dp[i] = nums[i];
            if (dp[i] >= 0) dp[i] += dp[i - 1];
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
