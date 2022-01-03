package TwoPointer;

import java.util.ArrayList;
import java.util.List;

public class CamelcaseMatching1023 {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> res = new ArrayList<>();
        for (String query : queries) {
            res.add(check(query, pattern));
        }
        return res;
    }

    private Boolean check(String query, String pattern) {
        int j = 0;
        for (Character c : query.toCharArray()) {
            if (j < pattern.length() && c == pattern.charAt(j)) j++;
            else if (c < 'a') return false;
        }
        return j == pattern.length();
    }
}
