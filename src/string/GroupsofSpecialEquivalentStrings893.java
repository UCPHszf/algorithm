package string;

import java.util.Arrays;
import java.util.HashSet;

public class GroupsofSpecialEquivalentStrings893 {
    public int numSpecialEquivGroups(String[] words) {
        HashSet<String> S = new HashSet<>();
        for (String word : words) {
            String a = "", b = "";
            for (int i = 0; i < word.length(); i += 2) {
                a += word.charAt(i);
                b += word.charAt(i + 1);
            }
            char[] a1 = a.toCharArray();
            char[] b1 = b.toCharArray();
            Arrays.sort(a1);
            Arrays.sort(b1);
            String str = String.valueOf(a1) + String.valueOf(b1);
            S.add(str);
        }
        return S.size();
    }
}
