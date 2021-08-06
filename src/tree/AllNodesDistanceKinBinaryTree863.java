package tree;

import datastructure.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllNodesDistanceKinBinaryTree863 {
    ArrayList<Integer> res = new ArrayList<>();
    Map<TreeNode, List<TreeNode>> map = new HashMap<>();

    public void dfsRoot(TreeNode root) {
        if (root.left != null) {
            map.computeIfAbsent(root, k -> new ArrayList<>());
            map.get(root).add(root.left);
            System.out.println(map.get(root).size());
            map.computeIfAbsent(root.left, k -> new ArrayList<>());
            map.get(root.left).add(root);
            dfsRoot(root.left);
        }
        if (root.right != null) {
            map.computeIfAbsent(root, k -> new ArrayList<>());
            map.get(root).add(root.right);
            map.computeIfAbsent(root.right, k -> new ArrayList<>());
            map.get(root.right).add(root);
            dfsRoot(root.right);
        }
    }

    public void dfsTarget(TreeNode root, TreeNode father, int k) {
        if (k == 0) res.add(root.val);
        for (TreeNode son : map.get(root)) {
            if (son != father) dfsTarget(son, root, k - 1);
        }
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        dfsRoot(root);
        dfsTarget(target, null, k);
        return res;
    }


}
