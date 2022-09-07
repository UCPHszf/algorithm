package leetcode.editor.cn;//给出二叉树的根节点 root，树上每个节点都有一个不同的值。
//
// 如果节点值在 to_delete 中出现，我们就把该节点从树上删去，最后得到一个森林（一些不相交的树构成的集合）。 
//
// 返回森林中的每棵树。你可以按任意顺序组织答案。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [1,2,3,4,5,6,7], to_delete = [3,5]
//输出：[[1,2,null,4],[6],[7]]
// 
//
// 示例 2： 
//
// 
//输入：root = [1,2,4,null,3], to_delete = [3]
//输出：[[1,2,4]]
// 
//
// 
//
// 提示： 
//
// 
// 树中的节点数最大为 1000。 
// 每个节点都有一个介于 1 到 1000 之间的值，且各不相同。 
// to_delete.length <= 1000 
// to_delete 包含一些从 1 到 1000、各不相同的值。 
// 
//
// Related Topics 树 深度优先搜索 二叉树 👍 194 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

//import datastructure.TreeNode;

import datastructure.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class DeleteNodesAndReturnForest1110 {
    List<TreeNode> res = new ArrayList<>();
    HashSet<Integer> s = new HashSet<>();


    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        for (int i : to_delete) s.add(i);
        if (!s.contains(root.val)) {
            res.add(root);
        }
        dfs(root);
        return res;
    }

    public TreeNode dfs(TreeNode root) {
        if (root == null) return null;
        root.left = dfs(root.left);
        root.right = dfs(root.right);
        if (s.contains(root.val)) {
            if (root.left != null)
                res.add(root.left);
            if (root.right != null)
                res.add(root.right);
            root = null;
        }
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
