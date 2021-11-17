package segment_tree;

import java.util.Map;
import java.util.TreeMap;

public class MyCalendarIII732 {

    TreeMap<Integer, Integer> map = new TreeMap<>();
    int MAX = 0;

    public MyCalendarIII732() {

    }

    public int book(int start, int end) {
        map.put(start, map.getOrDefault(start, 0) + 1);
        map.put(start, map.getOrDefault(end, 0) - 1);
        int sum = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            sum += entry.getValue();
            if (sum > MAX)
                MAX = sum;
        }
        return MAX;
    }
}
