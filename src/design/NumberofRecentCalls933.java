package design;

import java.util.LinkedList;
import java.util.Queue;

public class NumberofRecentCalls933 {

    Queue<Integer> q;

    public NumberofRecentCalls933() {
        q = new LinkedList<>();
    }

    public int ping(int t) {
        while (!q.isEmpty() && t - q.peek() > 3000) {
            q.poll();
        }
        q.add(t);
        return q.size();
    }
}
