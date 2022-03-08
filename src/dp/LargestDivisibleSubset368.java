package dp;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargestDivisibleSubset368 {

    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        ArrayList<Integer>[] f = new ArrayList[nums.length];
        int[] dp = new int[nums.length];
        for (int i = 0; i < f.length; i++) {
            f[i] = new ArrayList<>();
        }
        Arrays.fill(dp, 1);
        f[0].add(nums[0]);
        List<Integer> res = f[0];
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        f[i].clear();
                        f[i].addAll(f[j]);
                    }
                }
            }
            f[i].add(nums[i]);
            if (f[i].size() > res.size()) res = f[i];
        }
        return res;
    }

    @Test
    public void testCase1() {
        int[] test = {5, 9, 18, 54, 90, 108, 180, 360, 540, 720};
        System.out.println(largestDivisibleSubset(test));
    }
}
