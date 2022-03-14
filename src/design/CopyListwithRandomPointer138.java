package design;


import java.util.HashMap;

public class CopyListwithRandomPointer138 {
    class Node {
        int val;
        design.Node next;
        design.Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        HashMap<Node, Node> map = new HashMap<>();

    }
}
