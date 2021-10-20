package slidesWindow;

public class LongestRepeatingCharacterReplacement424 {
    public int characterReplacement(String s, int k) {
        int res = 0;
        for (char c = 'A'; c <= 'Z'; c++) {
            for (int i = 0, j = 0, cnt = 0; i < s.length(); i++) {
                if (s.charAt(i) == c) cnt++;
                while (i - j + 1 - cnt > k) {
                    if (s.charAt(j) == c) cnt--;
                    j++;
                }
                res = Math.max(res, i - j + 1);
            }
        }
        return res;
    }
}
