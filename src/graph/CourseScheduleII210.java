package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseScheduleII210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer> res = new ArrayList<>();
        List<List<Integer>> g = new ArrayList<>();
        int[] d = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            g.add(new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            int b = prerequisite[0], a = prerequisite[1];
            g.get(a).add(b);
            d[b]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < d.length; i++) {
            if (d[i] == 0)
                q.add(i);
        }
        while (!q.isEmpty()) {
            int t = q.poll();
            res.add(t);
            for (Integer i : g.get(t)) {
                if (--d[i] == 0) q.add(i);
            }
        }
        if (res.size() < numCourses) {
            res.clear();
        }
        return res.stream().mapToInt(Integer::valueOf).toArray();
    }
}
