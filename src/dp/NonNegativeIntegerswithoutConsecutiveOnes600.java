package dp;


import java.util.ArrayList;
import java.util.List;

public class NonNegativeIntegerswithoutConsecutiveOnes600 {
    // 预处理 f(i,0)及f(i,1)表示i位，最高位为0或1满足条件的个数
    public int findIntegers(int n) {
        List<Integer> num = new ArrayList<>();
        while (n > 0) {
            num.add(n % 2);
            n /= 2;
        }
        int[][] dp = new int[num.size() + 1][2];
        dp[1][0] = dp[1][1] = 1;
        for (int i = 2; i <= num.size(); i++) {
            dp[i][0] = dp[i - 1][0] + dp[i - 1][1];
            dp[i][1] = dp[i - 1][0];
        }
        int res = 0;
        for (int i = num.size(), last = 0; i > 0; i--) {
            int x = num.get(i - 1);
            if (x == 1) {
                res += dp[i][0];
                if (last == 1) return res;
            }
            last = x;
        }
        return res + 1;
    }
}
