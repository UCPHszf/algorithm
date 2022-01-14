package graph;

import java.util.*;

public class BipartiteGraphCheck785 {
    public boolean isBipartite(int[][] graph) {
        int[] color = new int[graph.length];
        List<List<Integer>> g = new ArrayList<>();
        for (int i = 0; i < graph.length; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < graph[i].length; j++) {
                list.add(graph[i][j]);
            }
        }
        for (int i = 0; i < graph.length; i++) {
            if (g.get(i).size() > 0 && color[i] == 0) {
                Queue<Integer> q = new LinkedList<>();
                q.add(i);
                while (!q.isEmpty()) {
                    int u = q.poll();
                    for (int j = 0; j < g.get(u).size(); j++) {
                        int v = g.get(u).get(j);
                        if (color[v] != 0 && color[u] == color[v]) return false;
                        if (color[v] == 0) {
                            color[v] = 3 - color[u];
                            q.add(v);
                        }
                    }
                }
            }
        }
        return true;
    }
}
