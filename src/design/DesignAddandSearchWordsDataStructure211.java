package design;

public class DesignAddandSearchWordsDataStructure211 {
    /**
     * Initialize your data structure here.
     */
    class Node {
        boolean isLeaf;
        Node[] son = new Node[26];

        Node() {
            isLeaf = false;
            for (int i = 0; i < 26; i++) {
                son[i] = null;
            }
        }
    }

    Node root;

    public DesignAddandSearchWordsDataStructure211() {
        root = new Node();
    }

    public void addWord(String word) {
        Node p = root;
        for (char ch : word.toCharArray()) {
            int u = ch - 'a';
            if (p.son[u] == null) p.son[u] = new Node();
            p = p.son[u];
        }
        p.isLeaf = true;
    }

    public boolean search(String word) {
        return dfs(root, word, 0);
    }

    boolean dfs(Node root, String word, int u) {
        if (u == word.length()) return root.isLeaf;
        if (word.charAt(u) != '.') {
            int i = word.charAt(u) - 'a';
            if (root.son[i] == null) return false;
            return dfs(root.son[i], word, u + 1);
        } else {
            for (int i = 0; i < 26; i++) {
                if (root.son[i] != null && dfs(root.son[i], word, u + 1)) {
                    return true;
                }
            }
            return false;
        }
    }
}
