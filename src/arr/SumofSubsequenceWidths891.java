package arr;

import java.util.Arrays;

public class SumofSubsequenceWidths891 {
    public int sumSubseqWidths(int[] nums) {
        int MOD = 1000000007;
        Arrays.sort(nums);
        long[] p = new long[20010];
        p[0] = 1;
        for (int i = 1; i < p.length; i++) {
            p[i] = (int) (p[i - 1] * 2 % MOD);
        }
        long res = 0;
        for (int i = 0; i < nums.length; i++) {
            res = (res + (p[i] - p[nums.length - i - 1]) * nums[i]) % MOD;
        }
        return (int) res;
    }
}
