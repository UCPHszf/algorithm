package tree;

import datastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FindModeinBinarySearchTree501 {
    List<Integer> res = new ArrayList<>();
    int base, count, maxCount;

    public int[] findMode(TreeNode root) {
        dfs(root);
        return res.stream().mapToInt(Integer::valueOf).toArray();
    }

    void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        update(root.val);
        dfs(root.right);
    }

    void update(int val) {
        if (val == base) {
            count++;
        } else {
            base = val;
            count = 1;
        }
        if (count == maxCount) {
            res.add(val);
        } else if (count > maxCount) {
            res.clear();
            res.add(val);
        }
    }
}

