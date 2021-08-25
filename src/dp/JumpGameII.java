package dp;

import java.util.Arrays;

public class JumpGameII {
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j <= i + nums[i]; j++) {
                if (j > 0 && j < nums.length) {
                    dp[j] = Math.min(dp[j], dp[i] + 1);
                    if (j == nums.length - 1) return dp[j];
                }
            }
        }
        return dp[dp.length - 1];
    }
}
