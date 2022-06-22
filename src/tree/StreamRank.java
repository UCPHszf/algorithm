package tree;

public class StreamRank {

    class Node {
        int val;
        int cnt;
        Node left;
        Node right;

        public void setCnt(int cnt) {
            this.cnt = cnt;
        }

        public Node(int val, int cnt) {
            this.val = val;
            this.cnt = cnt;
        }
    }

    Node root;

    public StreamRank() {

    }

    public void track(int x) {
        if (root == null) {
            root = new Node(x, 1);
        } else {
            Node cur = root;
            while (true) {
                if (x == cur.val) {
                    cur.setCnt(cur.cnt + 1);
                    return;
                } else if (x < cur.val) {
                    if (cur.left != null) {
                        cur = cur.left;
                    } else {
                        Node l = new Node(x, 1);
                        cur.left = l;
                        return;
                    }
                } else {
                    if (cur.right != null) {
                        cur = cur.right;
                    } else {
                        Node r = new Node(x, 1);
                        cur.right = r;
                        return;
                    }
                }
            }
        }
    }

    public int getRankOfNumber(int x) {
        return getRank(x, root);
    }

    public int getRank(int x, Node node) {
        if (node == null) return 0;
        else {
            Node cur = node;
            if (cur.val > x) {
                return getRank(x, node.left);
            } else {
                return cur.cnt + getSum(node.left) + getRank(x, node.right);
            }
        }
    }

    public int getSum(Node node) {
        if (node == null) return 0;
        int cnt = node.cnt;
        if (node.left != null) cnt += getSum(node.left);
        if (node.right != null) cnt += getSum(node.right);
        return cnt;
    }
}
