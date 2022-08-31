package tree;

import datastructure.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AllElementsinTwoBinarySearchTrees1305 {
    List<Integer> res = new ArrayList<>();

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        inOrder(root1);
        inOrder(root2);
        Collections.sort(res);
        return res;
    }

    public void inOrder(TreeNode root) {
        if (root != null) {
            inOrder(root.left);
            res.add(root.val);
            inOrder(root.right);
        }
    }
}
