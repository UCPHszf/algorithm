package tree;

import datastructure.TreeNode;

public class CousinsinBinaryTree993 {

    class Result {
        TreeNode father;
        int depth;

        public Result(TreeNode father, int depth) {
            this.father = father;
            this.depth = depth;
        }
    }

    public boolean isCousins(TreeNode root, int x, int y) {
        Result xRes = dfs(root, null, x, 0);
        Result yRes = dfs(root, null, y, 0);
        return xRes.father != yRes.father && xRes.depth == yRes.depth;
    }

    public Result dfs(TreeNode root, TreeNode father, int val, int depth) {
        if (root == null) return null;
        if (root.val == val) {
            return new Result(father, depth);
        } else {
            Result findL = dfs(root.left, root, val, depth + 1);
            Result findR = dfs(root.right, root, val, depth + 1);
            return findL == null ? findR : findL;
        }
    }
}
