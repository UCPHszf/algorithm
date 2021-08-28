package backtrack;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class WordSearchII212 {

    class Node {
        Node[] son = new Node[26];
        int id;

        Node() {
            id = -1;
            for (int i = 0; i < 26; i++) {
                son[i] = null;
            }
        }
    }

    Node root;

    void add(String word, int id) {
        Node p = root;
        for (int i = 0; i < word.length(); i++) {
            int u = word.charAt(i) - 'a';
            if (p.son[u] == null) {
                p.son[u] = new Node();
                p = p.son[u];
            }
        }
        p.id = id;
    }

    List<String> res = new ArrayList<>();
    HashSet<Integer> id = new HashSet<>();
    char[][] g;
    int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};

    public List<String> findWords(char[][] board, String[] words) {
        root = new Node();
        for (int i = 0; i < words.length; i++) {
            add(words[i], i);
        }
        g = board;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int u = board[i][j] - 'a';
                if (root.son[u] != null) {
                    dfs(i, j, root.son[u]);
                }
            }
        }
        for (Integer i : id) {
            res.add(words[i]);
        }
        return res;
    }

    private void dfs(int i, int j, Node node) {
        if (node.id != -1) id.add(node.id);
        char ch = g[i][j];
        g[i][j] = '.';
        for (int k = 0; k < 4; k++) {
            int x = i + dx[k], y = j + dy[k];
            if (x >= 0 && x < g.length && y >= 0 && y < g[0].length && g[x][y] != '.') {
                int u = g[x][y] - 'a';
                if (node.son[u] != null) dfs(x, y, node.son[u]);
            }
        }
        g[i][j] = ch;
    }
}
