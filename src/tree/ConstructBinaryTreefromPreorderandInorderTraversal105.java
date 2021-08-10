package tree;

import datastructure.TreeNode;

import java.util.HashMap;

public class ConstructBinaryTreefromPreorderandInorderTraversal105 {
    HashMap<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return build(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    public TreeNode build(int[] preorder, int[] inorder, int pl, int pr, int il, int ir) {
        if (pl > pr) return null;
        TreeNode node = new TreeNode(preorder[pl]);
        int offset = map.get(node.val);
        node.left = build(preorder, inorder, pl + 1, pl + 1 + offset - 1 - il, il, offset - 1);
        node.right = build(preorder, inorder, pl + 1 + offset - 1 - il + 1, pr, offset + 1, ir);
        return node;
    }
}
