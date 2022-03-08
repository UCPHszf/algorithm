package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PossibleBipartition886 {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        List<List<Integer>> g = new ArrayList<>();
        int[] colors = new int[n];
        for (int i = 0; i <= dislikes.length; i++) {
            List<Integer> l = new ArrayList<>();
            g.add(l);
        }
        for (int[] dislike : dislikes) {
            g.get(dislike[0]).add(dislike[1]);
        }
        for (int i = 1; i <= n; i++) {
            if (g.get(i).size() >= 0 && colors[i] == 0) {
                Queue<Integer> q = new LinkedList<>();
                q.add(i);
                while (!q.isEmpty()) {
                    int u = q.poll();
                    for (int j = 0; j < g.get(u).size(); j++) {
                        int v = g.get(u).get(j);
                        if (colors[v] != 0 && colors[u] == colors[v]) return false;
                        if (colors[v] == 0) {
                            colors[v] = 3 - colors[u];
                            q.add(v);
                        }
                    }
                }
            }
        }
        return true;
    }
}
