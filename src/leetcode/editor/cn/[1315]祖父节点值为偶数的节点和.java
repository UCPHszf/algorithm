package leetcode.editor.cn;//给你一棵二叉树，请你返回满足以下条件的所有节点的值之和：
//
// 
// 该节点的祖父节点的值为偶数。（一个节点的祖父节点是指该节点的父节点的父节点。） 
// 
//
// 如果不存在祖父节点值为偶数的节点，那么返回 0 。 
//
// 
//
// 示例： 
//
// 
//
// 输入：root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
//输出：18
//解释：图中红色节点的祖父节点的值为偶数，蓝色节点为这些红色节点的祖父节点。
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数目在 1 到 10^4 之间。 
// 每个节点的值在 1 到 100 之间。 
// 
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 76 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import datastructure.TreeNode;

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
class SumofNodeswithEvenValuedGrandparent1315 {

    int res = 0;

    public int sumEvenGrandparent(TreeNode root) {
        dfs(root, root.left);
        dfs(root, root.right);
        return res;
    }

    public void dfs(TreeNode parent, TreeNode son) {
        if (son==null||(son.left == null && son.right == null)) return;
        if (son.left != null) {
            if (parent.val % 2 == 0) {
                res += son.left.val;
            }
            dfs(son, son.left);
        }
        if (son.right != null) {
            if (parent.val % 2 == 0) {
                res += son.right.val;
            }
            dfs(son, son.right);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
