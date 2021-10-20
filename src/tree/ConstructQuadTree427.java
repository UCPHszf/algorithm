package tree;

import datastructure.quadtree.Node;

public class ConstructQuadTree427 {
    int[][] sum;

    public Node construct(int[][] grid) {
        int n = grid.length;
        sum = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1] + grid[i - 1][j - 1];
            }
        }
        return dfs(1, 1, n, n);
    }

    Node dfs(int x1, int y1, int x2, int y2) {
        int n = x2 - x1 + 1;
        int s = sum[x2][y2] - sum[x2][y1 - 1] - sum[x1 - 1][y2] + sum[x1 - 1][y1 - 1];
        if (s == 0) return new Node(false, true);
        if (s == n * n) return new Node(true, true);
        Node node = new Node(false, false);
        int m = n / 2;
        node.topLeft = dfs(x1, y1, x1 + m - 1, y1 + m - 1);
        node.topRight = dfs(x1, y1 + m, x1 + m - 1, y2);
        node.bottomLeft = dfs(x1 + m, y1, x2, y1 + m - 1);
        node.bottomRight = dfs(x1 + m, y1 + m, x2, y2);
        return node;
    }
}
