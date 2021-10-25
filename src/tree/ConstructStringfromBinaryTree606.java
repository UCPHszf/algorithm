package tree;

import datastructure.TreeNode;

public class ConstructStringfromBinaryTree606 {
    String res = "";

    public String tree2str(TreeNode root) {
        dfs(root);
        return res;
    }

    public void dfs(TreeNode root) {
        if (root == null) return;
        res += String.valueOf(root.val);
        if (root.left != null || root.right != null) {
            res += '(';
            dfs(root.left);
            res += ')';
        }
        if (root.right != null) {
            res += '(';
            dfs(root.right);
            res += ')';
        }
    }
}
