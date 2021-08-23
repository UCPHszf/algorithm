package string;

import java.util.Stack;

public class SimplifyPath71 {
    public String simplifyPath(String path) {
        String res = "/";
        StringBuilder cur = new StringBuilder("/");
        Stack<String> s = new Stack<>();
        for (int i = 1; i < path.length(); i++) {
            char ch = path.charAt(i);
            if (ch == '/') {
                if (getLastCharacter(cur) != '/') {
                    cur.append(ch);
                }
            } else if (ch == '.') {
                if (getLastCharacter(cur) == '.') {

                }
            }
        }
        return res;
    }

    public Character getLastCharacter(StringBuilder s) {
        return s.charAt(s.length() - 1);
    }
}
