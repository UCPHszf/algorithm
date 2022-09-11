package leetcode.editor.cn;//给定一个二叉树，我们在树的节点上安装摄像头。
//
// 节点上的每个摄影头都可以监视其父对象、自身及其直接子对象。 
//
// 计算监控树的所有节点所需的最小摄像头数量。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：[0,0,null,0,0]
//输出：1
//解释：如图所示，一台摄像头足以监控所有节点。
// 
//
// 示例 2： 
//
// 
//
// 输入：[0,0,null,0,null,0,null,null,0]
//输出：2
//解释：需要至少两个摄像头来监视树的所有节点。 上图显示了摄像头放置的有效位置之一。
// 
//
// 提示： 
//
// 
// 给定树的节点数的范围是 [1, 1000]。 
// 每个节点的值都是 0。 
// 
//
// Related Topics 树 深度优先搜索 动态规划 二叉树 👍 470 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

//import datastructure.TreeNode;

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
class MonitorBST968 {

    static int INF = Integer.MAX_VALUE - 10000;

    public int minCameraCover(TreeNode root) {
        int[] f = dfs(root);
        return Math.min(f[1], f[2]);
    }

    // f[0] observed by parent f[1] observed by son f[2] observed by itself
    int[] dfs(TreeNode root) {
        if (root == null) return new int[]{0, 0, INF};
        int[] l = dfs(root.left), r = dfs(root.right);
        return new int[]{
                Math.min(l[1], l[2]) + Math.min(r[1], r[2]),
                Math.min(l[2] + Math.min(r[1], r[2]), r[2] + Math.min(l[1], l[2])),
                Math.min(l[0], Math.min(l[1], l[2])) + Math.min(r[0], Math.min(r[1], r[2])) + 1
        };
    }
}
//leetcode submit region end(Prohibit modification and deletion)
