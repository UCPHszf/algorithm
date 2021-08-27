package backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueensI51 {
    List<List<String>> res = new ArrayList<>();
    char[][] path;
    int n;
    boolean[] dg, udg, col;

    public List<List<String>> solveNQueens(int _n) {
        n = _n;
        dg = new boolean[2 * n];
        udg = new boolean[2 * n];
        col = new boolean[n];
        path = new char[n][n];
        for (char[] chars : path) {
            Arrays.fill(chars, '.');
        }
        dfs(0);
        return res;
    }

    void dfs(int u) {
        if (u == n) {
            List<String> tmp = new ArrayList<>();
            for (char[] chars : path) {
                tmp.add(new String(chars));
            }
            res.add(tmp);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!col[i] && !dg[u - i + n] && !udg[u + i]) {
                col[i] = dg[u - i + n] = udg[u + i] = true;
                path[u][i] = 'Q';
                dfs(u + 1);
                path[u][i] = '.';
                col[i] = dg[u - i + n] = udg[u + i] = false;
            }
        }
    }
}
