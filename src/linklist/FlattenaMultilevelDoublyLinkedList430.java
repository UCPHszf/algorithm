package linklist;

import datastructure.listnode_child.Node;

public class FlattenaMultilevelDoublyLinkedList430 {
    public Node flatten(Node head) {
        Node[] res = dfs(head);
        return res[0];
    }

    Node[] dfs(Node head) {
        if (head == null) return new Node[]{null, null};
        Node cur = head, tail = head;
        while (cur != null) {
            tail = cur;
            if (cur.child != null) {
                Node[] t = dfs(cur.child);
                cur.child = null;
                t[1].next = cur.next;
                if (cur.next != null) cur.next.prev = t[1];
                cur.next = t[0];
                t[0].prev = cur;
                cur = t[1].next;
                tail = t[1];
            } else {
                cur = cur.next;
            }

        }
        return new Node[]{head, tail};
    }
}
