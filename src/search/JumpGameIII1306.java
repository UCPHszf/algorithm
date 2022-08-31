package search;

import java.util.LinkedList;
import java.util.Queue;

public class JumpGameIII1306 {
    public boolean canReach(int[] arr, int start) {
        int n = arr.length;
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        boolean[] visited = new boolean[n];
        visited[start] = true;
        while (!q.isEmpty()) {
            int idx = q.poll();
            int num = arr[idx];
            if (num == 0) return true;
            if (idx + num < n && !visited[idx + num]) {
                q.add(idx + num);
                visited[idx + num] = true;
            }
            if (idx - num >= 0 && !visited[idx - num]) {
                q.add(idx - num);
                visited[idx - num] = true;
            }
        }
        return false;
    }
}
