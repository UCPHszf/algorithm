package dp;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class PalindromePartitioning131 {
    List<List<String>> res = new ArrayList<>();
    List<String> path = new ArrayList<>();
    boolean[][] f;

    public List<List<String>> partition(String s) {
        f = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                if (i == j) f[i][j] = true;
                else if (s.charAt(i) == s.charAt(j)) {
                    if (j + 1 > i - 1 || f[i + 1][j - 1]) f[i][j] = true;
                }
            }
        }
        dfs(s, 0);
        return res;
    }

    public void dfs(String s, int offset) {
        if (offset == s.length()) res.add(path);
        else {
            for (int i = offset; i < s.length(); i++) {
                if (f[offset][i]) {
                    path.add(s.substring(offset, i - offset + 1));
                    dfs(s, offset + 1);
                    path.remove(path.size() - 1);
                }
            }
        }
    }
}
