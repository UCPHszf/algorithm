package string;

import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters3 {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> h = new HashSet<>();
        int res = 0;
        int idx = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (h.contains(ch)) {
                while (h.contains(ch)) {
                    h.remove(s.charAt(idx++));
                }
            }
            h.add(ch);
            if (h.size() > res) {
                res = h.size();
            }
        }
        return res;
    }
}
