package search;

import java.util.ArrayList;
import java.util.List;

public class LexicographicalNumbers386 {
    List<Integer> res = new ArrayList<>();

    public List<Integer> lexicalOrder(int n) {
        for (int i = 1; i <= 9; i++) dfs(i, n);
        return res;
    }

    void dfs(int cur, int n) {
        if (cur <= n) res.add(cur);
        if (cur > n) return;
        for (int i = 0; i <= 9; i++) dfs(cur * 10 + i, n);
    }
}
