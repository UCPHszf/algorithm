package tree;

import datastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTreesII95 {
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> res = new ArrayList<>();
        if (n == 0) return res;
        return generate(1, n);
    }

    public List<TreeNode> generate(int start, int end) {
        List<TreeNode> allTrees = new ArrayList<>();
        if (start > end) {
            allTrees.add(null);
            return allTrees;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> l = generate(start, i - 1);
            List<TreeNode> r = generate(i + 1, end);
            for (TreeNode left_node : l) {
                for (TreeNode right_node : r) {
                    TreeNode node = new TreeNode(i);
                    node.left = left_node;
                    node.right = right_node;
                    allTrees.add(node);
                }
            }
        }
        return allTrees;
    }
}
