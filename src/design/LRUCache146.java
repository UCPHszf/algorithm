package design;

import java.util.*;

public class LRUCache146 {

    class Node {
        int key, value;
        Node prev;
        Node next;

        public Node(int k, int v) {
            this.prev = null;
            this.next = null;
            this.key = k;
            this.value = v;
        }
    }

    int n;
    Node head;
    Node tail;
    Map<Integer, Node> hash;

    void remove(Node node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }

    void insert(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    public LRUCache146(int capacity) {
        hash = new HashMap<>();
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!hash.containsKey(key)) {
            return -1;
        } else {
            Node node = hash.get(key);
            remove(node);
            insert(node);
            return node.value;
        }
    }

    public void put(int key, int value) {
        if (hash.containsKey(key)) {
            Node node = hash.get(key);
            node.value = value;
            remove(node);
            insert(node);
        } else {
            Node node = new Node(key, value);
            hash.put(key, node);
            insert(node);
        }
    }
}
