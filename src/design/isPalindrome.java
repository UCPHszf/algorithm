package design;

import java.util.HashMap;
import java.util.Map;

public class isPalindrome {
    public boolean canPermutePalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) map.put(ch, map.getOrDefault(ch, 0) + 1);
        int odd = 0;
        for (int i : map.values()) if (i % 2 == 1) odd++;
        return odd < 2;
    }
}
