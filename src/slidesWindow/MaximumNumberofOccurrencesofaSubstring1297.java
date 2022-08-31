package slidesWindow;

import java.util.*;

public class MaximumNumberofOccurrencesofaSubstring1297 {

    Map<String, Integer> map = new HashMap<>();

    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        for (int i = minSize; i < maxSize; i++) {
            slideWindow(s, maxLetters, i);
        }
        int res = 0;
        for (int i : map.values()) {
            if (i > res) res = i;
        }
        return res;
    }

    public void slideWindow(String s, int maxLetters, int windowSize) {
        int[] cnt = new int[26];
        int diff = 0;
        String initStr = s.substring(0, windowSize);
        for (char c : initStr.toCharArray()) {
            if (cnt[c - 'a'] == 0) {
                diff++;
            }
            cnt[c - 'a']++;
        }
        if (diff <= maxLetters) map.put(initStr, 1);
        for (int i = windowSize; i < s.length(); i++) {
            char oldCh = s.charAt(i - windowSize);
            char newCh = s.charAt(i);
            String newStr = s.substring(i - windowSize + 1, i + 1);
            System.out.println(newStr);
            if (cnt[oldCh - 'a'] == 0) diff--;
            cnt[oldCh - 'a']--;
            if (cnt[newCh - 'a'] == 0) diff++;
            cnt[newCh - 'a']++;
            if (diff <= maxLetters) map.put(newStr, map.getOrDefault(newStr, 0) + 1);
        }
    }
}
