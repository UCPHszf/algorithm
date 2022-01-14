package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MinimumHeightTrees310 {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>();
        if (n == 1) {
            res.add(0);
            return res;
        }
        int[] degrees = new int[n];
        List<List<Integer>> g = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            g.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            degrees[edge[0]]++;
            degrees[edge[1]]++;
            g.get(edge[0]).add(edge[1]);
            g.get(edge[1]).add(edge[0]);
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < degrees.length; i++) {
            if (degrees[i] == 1) {
                q.add(i);
            }
        }
        while (!q.isEmpty()) {
            res = new ArrayList<>();
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int v = q.poll();
                res.add(v);
                for (int neighbour : g.get(v)) {
                    degrees[neighbour]--;
                    if (degrees[neighbour] == 1) {
                        q.add(neighbour);
                    }

                }
            }
        }
        return res;
    }
}
