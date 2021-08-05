package dp;

import java.util.Arrays;

public class CoinChangeII518 {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount+1];
        dp[0]=1;
        for(Integer x:coins){
            for(int i=x;i<=amount;i++)
                dp[i]+=dp[i-x];
        }
        return dp[amount];
    }
}
