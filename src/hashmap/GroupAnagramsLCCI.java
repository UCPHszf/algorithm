package hashmap;

import java.util.*;

public class GroupAnagramsLCCI {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> m = new HashMap<>();
        for (String str : strs) {
            char[] chArr = str.toCharArray();
            Arrays.sort(chArr);
            String sortedChArr = String.valueOf(chArr);
            if (m.containsKey(sortedChArr)) {
                System.out.println(str);
                m.get(sortedChArr).add(str);
            } else {
                List<String> stringList = new ArrayList<>();
                stringList.add(str);
                m.put(sortedChArr, stringList);
            }
        }
        return new ArrayList<>(m.values());
    }
}
