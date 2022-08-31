package hashmap;

import java.util.*;

public class GroupthePeopleGiventheGroupSizeTheyBelongTo1282 {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        Map<Integer, List<Integer>> m = new HashMap<>();
        for (int i = 0; i < groupSizes.length; i++) {
            int groupSize = groupSizes[i];
            if (!m.containsKey(groupSize)) {
                List<Integer> l = new ArrayList<>();
                m.put(groupSize, l);
            }
            m.get(groupSize).add(i);
        }
        List<List<Integer>> res = new ArrayList<>();
        for (Map.Entry<Integer, List<Integer>> entry : m.entrySet()) {
            int groupSize = entry.getKey();
            List<Integer> l = entry.getValue();
            if (l.size() == groupSize) {
                res.add(l);
            } else {
                List<Integer> tmp = new ArrayList<>();
                for (int i = 0; i < l.size(); i++) {
                    tmp.add(l.get(i));
                    if (tmp.size() == groupSize) {
                        res.add(new ArrayList<>(tmp));
                        tmp.clear();
                    }
                }
            }
        }
        return res;
    }
}
