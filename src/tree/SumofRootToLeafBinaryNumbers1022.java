package tree;

import datastructure.TreeNode;

public class SumofRootToLeafBinaryNumbers1022 {
    public int sumRootToLeaf(TreeNode root) {
        return dfs(root, "");
    }

    public int dfs(TreeNode root, String path) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return Integer.valueOf(path + root.val, 2);
        return dfs(root.left, path + root.val) + dfs(root.right, path + root.val);
    }
}
