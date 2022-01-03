package string;

import java.util.Stack;

public class RemoveOutermostParentheses1021 {
    public String removeOuterParentheses(String s) {
        String res = "";
        Stack<Character> stack = new Stack<>();
        //boolean polyFlag = false;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.add(c);
            } else {
                if (stack.size() > 1) {
                    res += stack.pop();
                    res += c;
                } else {
                    stack.pop();
                }
            }
        }
        return res;
    }
}
