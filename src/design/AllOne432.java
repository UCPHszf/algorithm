package design;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AllOne432 {

    Map<String, Node> map;

    class Node {
        Node prev;
        Node next;
        int val;
        Set<String> set;

        Node(int _val) {
            this.val = _val;
            this.prev = this.next = null;
            set = new HashSet<>();
        }
    }

    Node left, right;

    public AllOne432() {
        left = new Node(Integer.MIN_VALUE);
        right = new Node(Integer.MAX_VALUE);
        left.next = right;
        right.prev = left;
        map = new HashMap<>();
    }

    Node add_to_right(Node node, String key, int val) {
        if (node.next.val == val) node.next.set.add(key);
        else {
            Node newNode = new Node(val);

            newNode.next = node.next;
            node.next.prev = newNode;

            node.next = newNode;
            newNode.prev = node;
            newNode.set.add(key);
        }
        return node.next;
    }

    Node add_to_left(Node node, String key, int val) {
        if (node.prev.val == val) node.prev.set.add(key);
        else {
            Node newNode = new Node(val);

            newNode.prev = node.prev;
            node.prev.next = newNode;

            node.prev = newNode;
            newNode.next = node;
            newNode.set.add(key);
        }
        return node.prev;
    }

    void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void inc(String key) {
        if (!map.containsKey(key)) map.put(key, add_to_right(left, key, 1));
        else {
            Node node = map.get(key);
            node.set.remove(key);
            map.put(key, add_to_right(node, key, node.val + 1));
            if (node.set.isEmpty()) removeNode(node);
        }
    }

    public void dec(String key) {
        if (!map.containsKey(key)) return;
        Node node = map.get(key);
        node.set.remove(key);
        if (node.val > 1) map.put(key, add_to_left(node, key, node.val - 1));
        else map.remove(key);
        if (node.set.isEmpty()) removeNode(node);
    }

    public String getMaxKey() {
        if (right.prev != left) {
            return right.prev.set.stream().findFirst().orElse("");
        }
        return "";
    }

    public String getMinKey() {
        if (left.next != right) {
            return left.next.set.stream().findFirst().orElse("");
        }
        return "";
    }
}
