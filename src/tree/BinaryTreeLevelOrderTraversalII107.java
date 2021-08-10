package tree;

import datastructure.TreeNode;

import java.util.*;

public class BinaryTreeLevelOrderTraversalII107 {
    Stack<List<Integer>> s = new Stack<>();

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int n = q.size();
            for (int i = 0; i < n; i++) {
                TreeNode node = q.poll();
                list.add(node.val);
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
            }
            s.add(list);
        }
        List<List<Integer>> res = new ArrayList<>();
        while (!s.isEmpty()) {
            res.add(s.pop());
        }
        return res;
    }
}
