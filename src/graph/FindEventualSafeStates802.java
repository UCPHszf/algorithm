package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindEventualSafeStates802 {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> res = new ArrayList<>();
        List<List<Integer>> g = new ArrayList<>();
        int n = graph.length;
        for (int i = 0; i < n; i++) {
            g.add(new ArrayList<>());
        }
        int[] degree = new int[n];
        for (int i = 0; i < n; i++) {
            for (int num : graph[i]) {
                g.get(num).add(i);
            }
            degree[i] = graph[i].length;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < degree.length; i++) {
            if (degree[i] == 0) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            int v = queue.poll();
            for (int num : g.get(v)) {
                if (--degree[num] == 0) {
                    queue.add(num);
                }
            }
        }
        for (int i = 0; i < n; ++i) {
            if (degree[i] == 0) {
                res.add(i);
            }
        }
        return res;
    }
}
