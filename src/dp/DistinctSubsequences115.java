package dp;

public class DistinctSubsequences115 {
    int res = 0;

    public int numDistinct(String s, String t) {
//        dfs(0, 0, s, t, "");
//        return res;
        int m = s.length(), n = t.length();
        s = ' ' + s;
        t = ' ' + t;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) dp[i][0] = 1;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i - 1][j];
                if (s.charAt(i) == t.charAt(j)) dp[i][j] += dp[i - 1][j - 1];
            }
        }
        return dp[m][n];
    }

    private void dfs(int cur, int k, String s, String t, String str) {
        if (str.length() == t.length()) {
            if (str.equals(t)) res++;
            return;
        }
        if (cur == s.length() - 1) return;
        if (s.charAt(cur) == t.charAt(k)) {
            dfs(cur + 1, k + 1, s, t, str + s.charAt(cur));
        }
        dfs(cur + 1, k, s, t, str);
    }
}
