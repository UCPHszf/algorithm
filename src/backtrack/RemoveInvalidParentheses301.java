package backtrack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class RemoveInvalidParentheses301 {
    ArrayList<String> res = new ArrayList<>();

    public List<String> removeInvalidParentheses(String s) {
        int l = 0, r = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') l++;
            else if (ch == ')') {
                if (l == 0) r++;
                else l--;
            }
        }
        dfs(s, 0, "", 0, l, r);
        return res;
    }


    void dfs(String s, int offset, String cur, int cnt, int l, int r) {
        if (offset == s.length()) {
            if (cnt == 0) res.add(cur);
            return;
        }
        if (s.charAt(offset) != '(' && s.charAt(offset) != ')') dfs(s, offset + 1, cur + s.charAt(offset), cnt, l, r);
        else if (s.charAt(offset) == '(') {
            int k = offset;
        }
    }
}
