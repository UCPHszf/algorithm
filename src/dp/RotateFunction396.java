package dp;

public class RotateFunction396 {
    public int maxRotateFunction(int[] nums) {
        if (nums == null) return 0;
        int len = nums.length;
        int[] dp = new int[len];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            dp[0] += i * nums[i];
            sum += nums[i];
        }
        int max = dp[0];
        for (int i = 1; i < len; i++) {
            dp[i] = dp[i - 1] - nums[len - i] * (len - 1) + sum - nums[len - i];
            System.out.println(dp[i]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
