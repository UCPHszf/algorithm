package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AllPossiblePath797 {

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        dfs(0, graph);
        return res;
    }

    void dfs(int cur, int[][] graph) {
        if (graph[cur].length == 0 && cur != graph.length - 1) return;
        path.add(cur);
        if (cur == graph.length - 1) {
            res.add(new ArrayList<>(path));
            path.remove(path.size() - 1);
            return;
        }
        for (int i = 0; i < graph[cur].length; i++) {
            dfs(graph[cur][i], graph);
        }
        path.remove(path.size() - 1);
    }
}
