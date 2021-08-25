package dp;

import java.util.List;

public class Triangle120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] dp = new int[200];
        dp[0] = triangle.get(0).get(0);
        for (int i = 1; i < triangle.size(); i++) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                dp[j]=
            }
        }
        int res = Integer.MAX_VALUE;
        for (Integer i : dp) {
            res = Math.min(res, i);
        }
        return res;
    }
}
