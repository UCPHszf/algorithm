package string;


import java.util.Arrays;

public class FirstUniqChar387 {

    public int firstUniqChar(String s) {
        if (s == null || s.isEmpty()) return -1;
        int res = Integer.MAX_VALUE;
        int[] cnt = new int[26];
        int duplicate = 0;
        Arrays.fill(cnt, -2);
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (cnt[ch - 'a'] == -2) {
                cnt[ch - 'a'] = i;
            } else if (cnt[ch - 'a'] == -1) {
                continue;
            } else {
                cnt[ch - 'a'] = -1;
                duplicate++;
                if (duplicate == 26) {
                    return -1;
                }
            }
        }
        for (Integer i : cnt) {
            if (i >= 0) {
                res = Math.min(res, i);
            }
        }
        if (res == Integer.MAX_VALUE) return -1;
        return res;
    }
}
