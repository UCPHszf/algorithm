package RandomAlgorithm;

import java.util.*;

public class RandomizedSet380 {
    Map<Integer, Integer> map;
    List<Integer> list;

    public RandomizedSet380() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }

    public boolean insert(int val) {
        if (!map.containsKey(val)) {
            list.add(val);
            map.put(val, list.size() - 1);
            return true;
        }
        return false;
    }

    public boolean remove(int val) {
        if(map.containsKey(val)){
            int last=list.get(list.size()-1),last_idx=list.size()-1,val_idx = list.indexOf(val);
            list.set(val_idx,last);
            list.set(last_idx,val);
            map.put(val,last_idx);
            map.put(last,val_idx);
            map.remove(val);
            list.remove(new Integer(val));
            return true;
        }
        return false;
    }

    public int getRandom() {
        return list.get(new Random().nextInt() % list.size());
    }
}
