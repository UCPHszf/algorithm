package dp;

public class DeleteandEarn740 {
    public int deleteAndEarn(int[] nums) {
        int[] cnt = new int[10010];
        for (int i = 0; i < nums.length; i++) {
            cnt[nums[i]]++;
        }
        int res = 0;
        int[][] f = new int[nums.length + 1][2];
        for (int i = 1; i <= nums.length; i++) {
            f[i][0] = Math.max(f[i - 1][0], f[i - 1][1]);
            f[i][1] = f[i - 1][0] + i * cnt[i];
            res = Math.max(res, Math.max(f[i][0], f[i][1]));
        }
        return res;
    }
}
