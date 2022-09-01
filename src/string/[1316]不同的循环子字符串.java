package string;//给你一个字符串 text ，请你返回满足下述条件的 不同 非空子字符串的数目：
//
// 
// 可以写成某个字符串与其自身相连接的形式（即，可以写为 a + a，其中 a 是某个字符串）。 
// 
//
// 例如，abcabc 就是 abc 和它自身连接形成的。 
//
// 
//
// 示例 1： 
//
// 输入：text = "abcabcabc"
//输出：3
//解释：3 个子字符串分别为 "abcabc"，"bcabca" 和 "cabcab" 。
// 
//
// 示例 2： 
//
// 输入：text = "leetcodeleetcode"
//输出：2
//解释：2 个子字符串为 "ee" 和 "leetcodeleetcode" 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= text.length <= 2000 
// text 只包含小写英文字母。 
// 
//
// Related Topics 字典树 字符串 哈希函数 滚动哈希 👍 44 👎 0


import java.util.HashSet;

//leetcode submit region begin(Prohibit modification and deletion)
class DistinctEchoSubstrings1316 {
    static final int P = 131, N = 2010;
    long[] h = new long[N], p = new long[N];

    long getHash(int l, int r) {
        return h[r] - h[l - 1] * p[r - l + 1];
    }

    public int distinctEchoSubstrings(String text) {
        int n = text.length();
        p[0] = 1;
        for (int i = 1; i <= n; i++) {
            p[i] = p[i - 1] * P;
            h[i] = h[i - 1] * P + text.charAt(i - 1);
        }
        HashSet<Long> hashSet = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; i + j * 2 <= n + 1; j++) {
                long left = getHash(i, i + j - 1);
                long right = getHash(i + j, i + j * 2 - 1);
                if (left == right) hashSet.add(left);
            }
        }
        return hashSet.size();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
