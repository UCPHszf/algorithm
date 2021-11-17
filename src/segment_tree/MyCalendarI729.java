package segment_tree;


import java.util.TreeMap;

public class MyCalendarI729 {

    TreeMap<Integer, Integer> calendar;

    MyCalendarI729() {
        calendar = new TreeMap();
    }

    public boolean book(int start, int end) {
        Integer prev = calendar.floorKey(start);
        Integer next = calendar.ceilingKey(start);
        if ((prev == null || calendar.get(prev) <= start) && (next == null || end <= next)) {
            calendar.put(start, end);
            return true;
        }
        return false;
    }
}
