package string;

import java.util.*;

public class MostCommonWord819 {
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> s = new HashSet();
        s.addAll(Arrays.asList(banned));
        Map<String, Integer> map = new HashMap();
        String[] ss = paragraph.split(" ");
        for (String str : ss) {
            str = str.toLowerCase();
            char lastCh = str.charAt(str.length() - 1);
            if (!Character.isLetter(lastCh)) str = str.substring(0, str.length() - 1);
            if (!s.contains(str)) map.put(str, map.getOrDefault(str, 0) + 1);
        }
        for (String p : map.keySet()) {
            System.out.println(p + " " + map.get(p));
        }
        int max = 0;
        String res = "";
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > max) {
                res = entry.getKey();
                max = entry.getValue();
            }
        }
        return res;
    }
}
