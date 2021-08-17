package search;

import java.util.HashMap;
import java.util.Map;

public class DesignAddandSearchWordsDataStructure211 {

    private class Node {
        Map<Character, Node> next;
        boolean isWord;

        public Node(boolean isWord) {
            this.isWord = isWord;
            this.next = new HashMap<>();
        }

        public Node() {
            this(false);
        }
    }

    Node root;

    public DesignAddandSearchWordsDataStructure211() {
        root = new Node();
    }

    public void addWord(String word) {
        if (search(word)) return;
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (curr.next.get(c) == null) {
                curr.next.put(c, new Node());
            }
            curr = curr.next.get(c);
        }
        if (!curr.isWord) {
            curr.isWord = true;
        }
    }

    public boolean search(String word) {
        return false;
    }
}
