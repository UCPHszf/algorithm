package greedy;

import java.util.HashMap;
import java.util.Map;

public class TaskScheduler621 {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : tasks) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int maxCh = 0, cnt = 0;
        for (Integer i : map.values()) {
            maxCh = Math.max(maxCh, i);
        }
        for (Integer i : map.values()) {
            if (i == maxCh)
                cnt++;
        }
        return Math.max(tasks.length, (maxCh - 1) * (n + 1) + cnt);
    }
}
