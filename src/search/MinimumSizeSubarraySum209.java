package search;

import java.util.HashMap;

public class MinimumSizeSubarraySum209 {

    public int minSubArrayLen(int target, int[] nums) {
        int sum = 0;
        int len = Integer.MAX_VALUE;
        int i = 0, j = 0;
        while (i < nums.length) {
            sum += nums[i++];
            if (sum >= target) {
                while (j < i && sum - nums[j] >= target) {
                    sum -= nums[j++];
                }
                len = Math.min(len, i - j);
            }
        }
        return len;
    }
}
