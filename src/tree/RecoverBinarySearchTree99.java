package tree;

import datastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class RecoverBinarySearchTree99 {
    public void recoverTree(TreeNode root) {
        List<Integer> nums = new ArrayList<>();
        inorder(nums, root);
        int[] swapped = findTwoSwapped(nums);
        recover(root, 2, swapped[0], swapped[1]);
    }

    public void inorder(List<Integer> nums, TreeNode root) {
        if (root == null) return;
        inorder(nums, root.left);
        nums.add(root.val);
        inorder(nums, root.right);
    }

    public int[] findTwoSwapped(List<Integer> nums) {
        int n = nums.size();
        int idx1 = -1, idx2 = -1;
        for (int i = 0; i < n - 1; i++) {
            if (nums.get(i + 1) < nums.get(i)) {
                idx2 = i + 1;
                if (idx1 == -1) {
                    idx1 = i;
                } else {
                    break;
                }
            }
        }
        int x = nums.get(idx1), y = nums.get(idx2);
        return new int[]{x, y};
    }

    public void recover(TreeNode node, int cnt, int x, int y) {
        if (node != null) {
            if (node.val == x || node.val == y) {
                node.val = node.val == x ? y : x;
                if (--cnt == 0) {
                    return;
                }
            }
            recover(node.right, cnt, x, y);
            recover(node.left, cnt, x, y);
        }
    }
}
