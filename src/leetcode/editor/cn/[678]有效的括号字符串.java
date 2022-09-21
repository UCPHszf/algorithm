package leetcode.editor.cn;//给定一个只包含三种字符的字符串：（ ，） 和 *，写一个函数来检验这个字符串是否为有效字符串。有效字符串具有如下规则：
//
// 
// 任何左括号 ( 必须有相应的右括号 )。 
// 任何右括号 ) 必须有相应的左括号 ( 。 
// 左括号 ( 必须在对应的右括号之前 )。 
// * 可以被视为单个右括号 ) ，或单个左括号 ( ，或一个空字符串。 
// 一个空字符串也被视为有效字符串。 
// 
//
// 示例 1: 
//
// 
//输入: "()"
//输出: True
// 
//
// 示例 2: 
//
// 
//输入: "(*)"
//输出: True
// 
//
// 示例 3: 
//
// 
//输入: "(*))"
//输出: True
// 
//
// 注意: 
//
// 
// 字符串大小将在 [1，100] 范围内。 
// 
//
// Related Topics 栈 贪心 字符串 动态规划 👍 525 👎 0


import java.util.Arrays;
import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
class ValidParenthesisString678 {
    public boolean checkValidString(String s) {
        int n = s.length();
        Stack<Integer> lp_idx = new Stack<>();
        Stack<Integer> wc_idx = new Stack<>();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                lp_idx.add(i);
            } else if (ch == '*') {
                wc_idx.add(i);
            } else {
                if (!lp_idx.isEmpty()) lp_idx.pop();
                else if (!wc_idx.isEmpty()) wc_idx.pop();
                else return false;
            }
        }
        while (!lp_idx.isEmpty()) {
            if (!wc_idx.isEmpty()) {
                if (wc_idx.peek() > lp_idx.peek()) {
                    wc_idx.pop();
                    lp_idx.pop();
                } else return false;
            } else return false;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
