package dp;

public class HouseRobberII212 {
    public int rob(int[] nums) {
        int len = nums.length;
        int[][] f = new int[len + 1][2];
        f[0][0] = 0;
        f[0][1] = Integer.MIN_VALUE;
        for (int i = 1; i < f.length; i++) {
            f[i][0]=Math.max(f[i-1][0],f[i-1][1]);
            f[i][1]=f[i-1][0]+nums[i-1];
            if(i==len){

            }
        }
    }
}
