package leetcode.editor.cn;//给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的排列。如果是，返回 true ；否则，返回 false 。
//
// 换句话说，s1 的排列之一是 s2 的 子串 。 
//
// 
//
// 示例 1： 
//
// 
//输入：s1 = "ab" s2 = "eidbaooo"
//输出：true
//解释：s2 包含 s1 的排列之一 ("ba").
// 
//
// 示例 2： 
//
// 
//输入：s1= "ab" s2 = "eidboaoo"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s1.length, s2.length <= 10⁴ 
// s1 和 s2 仅包含小写字母 
// 
//
// Related Topics 哈希表 双指针 字符串 滑动窗口 👍 763 👎 0


import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class StringPermutation567 {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        int l = 0, r = s1.length();
        Map<Character, Integer> cnt = new HashMap<>();
        Map<Character, Integer> cur = new HashMap<>();
        for (char ch : s1.toCharArray()) {
            cnt.put(ch, cnt.getOrDefault(ch, 0) + 1);
        }
        for (int i = l; i < r; i++) {
            char ch = s2.charAt(i);
            cur.put(ch, cur.getOrDefault(ch, 0) + 1);
        }
        if (check(cnt, cur)) return true;
        while (r < s2.length()) {
            char rch = s2.charAt(r);
            cur.put(rch, cur.getOrDefault(rch, 0) + 1);
            r++;
            char lch = s2.charAt(l);
            cur.put(lch, cur.get(lch) - 1);
            if (cur.get(lch) == 0) cur.remove(lch);
            l++;
            if (check(cnt, cur)) return true;
        }
        return false;
    }

    private boolean check(Map<Character, Integer> cnt, Map<Character, Integer> cur) {
        for (Map.Entry<Character, Integer> entry : cnt.entrySet()) {
            char ch = entry.getKey();
            int val = entry.getValue();
            if (!(cur.containsKey(ch) && cur.get(ch) == val)) return false;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
