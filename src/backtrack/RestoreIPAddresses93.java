package backtrack;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses93 {
    ArrayList<String> res = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        dfs(s, 0, 0, "");
        return res;
    }

    void dfs(String s, int n, int offset, String t) {
        if (offset == s.length()) {
            if (n == 4) {
                t=t.substring(0,t.length()-1);
                res.add(t);
            }
            return;
        }
        if (n == 4) return;
        for (int i = offset, cur = 0; i < s.length(); i++) {
            if (i > offset && s.charAt(offset) == '0') break;
            cur = cur * 10 + s.charAt(i) - '0';
            if (cur <= 255) dfs(s, n + 1, i + 1, t + cur+ ".");
            else break;
        }
    }
}
