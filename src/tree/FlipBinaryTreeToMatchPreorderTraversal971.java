package tree;

import datastructure.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FlipBinaryTreeToMatchPreorderTraversal971 {
    List<Integer> res = new ArrayList<>();
    int k=0;
    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        if (dfs(root, voyage)) return res;
        else return new ArrayList<>(Collections.singletonList(1));
    }

    private boolean dfs(TreeNode root, int[] voyage) {
        if (root == null) return true;
        if (root.val != voyage[k]) return false;
        k++;
        if (root.left != null && root.left.val != voyage[k]) {
            res.add(root.val);
            return dfs(root.right, voyage) && dfs(root.left, voyage);
        } else {
            return dfs(root.left, voyage) && dfs(root.right, voyage);
        }
    }
}
