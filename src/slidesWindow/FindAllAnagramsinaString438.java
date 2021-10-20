package slidesWindow;

import java.util.ArrayList;
import java.util.List;

public class FindAllAnagramsinaString438 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (p.length() > s.length()) return res;
        int[] origin = new int[26];
        int[] dynamic = new int[26];
        for (int i = 0; i < p.length(); i++) {
            origin[p.charAt(i) - 'a']++;
            dynamic[s.charAt(i) - 'a']++;
        }
        int offset = 0;
        if (isAnagram(origin, dynamic)) res.add(offset);
        for (int i = 0; i < s.length() - p.length(); i++) {
            dynamic[s.charAt(i) - 'a']--;
            dynamic[s.charAt(i + p.length()) - 'a']++;
            offset++;
            if (isAnagram(origin, dynamic)) res.add(offset);
        }
        return res;
    }

    public boolean isAnagram(int[] origin, int[] dynamic) {
        for (int i = 0; i < origin.length; i++) {
            if (origin[i] != dynamic[i]) return false;
        }
        return true;
    }
}
