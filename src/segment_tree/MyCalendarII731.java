package segment_tree;

import java.util.HashMap;
import java.util.Map;

public class MyCalendarII731 {
    HashMap<Integer, Integer> map = new HashMap<>();

    public MyCalendarII731() {

    }

    public boolean book(int start, int end) {
        int sum = 0;
        map.put(start, map.getOrDefault(start, 0) + 1);
        map.put(end, map.getOrDefault(end, 0) - 1);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            sum += entry.getValue();
            if (sum >= 3) {
                map.put(start, map.getOrDefault(start, 0) - 1);
                map.put(end, map.getOrDefault(end, 0) + 1);
            }
            return false;
        }
        return true;
    }
}
