package hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimumIndexSumofTwoLists599 {
    public String[] findRestaurant(String[] list1, String[] list2) {
        List<String> res = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }
        int tmp = Integer.MAX_VALUE;
        for (int i = 0; i < list2.length; i++) {
            if (map.containsKey(list2[i])) {
                if (i + map.get(list2[i]) == tmp) res.add(list2[i]);
                else if (i + map.get(list2[i]) < tmp) {
                    tmp = i + map.get(list2[i]);
                    res.clear();
                    res.add(list2[i]);
                }
            }
        }
        return res.toArray(new String[0]);
    }
}
