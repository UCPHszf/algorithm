package tree;

import datastructure.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PathSumIII437 {
    Map<TreeNode, List<TreeNode>> map = new HashMap<>();
    int res = 0;

    void dfs(TreeNode node) {
        if (node == null) return;
        else {
            map.computeIfAbsent(node, k -> new ArrayList<>());
            if (node.left != null) {
                map.get(node).add(node.left);
                dfs(node.left);
            }
            if (node.right != null) {
                map.get(node).add(node.right);
                dfs(node.right);
            }
        }
    }

    void dfs2(TreeNode root, int val, int targetSum) {
        if (val == targetSum)
            res++;
        for (TreeNode node : map.get(root)) {
            dfs2(node, val + node.val, targetSum);
        }
    }

    public int pathSum(TreeNode root, int targetSum) {
        dfs(root);
        for (TreeNode node : map.keySet()) {
            dfs2(node, node.val, targetSum);
        }
        return res;
    }

    //前缀和算法
    Map<Integer,Integer> mem = new HashMap<Integer,Integer>();//保存前缀树
    int target;
    public int pathSum2(TreeNode root, int targetSum) {
        target = targetSum;
        mem.put(0,1);//前缀树为0的个数至少是一个
        return dfs(root,0);
        new Double(Double.valueOf((double) 1));
    }

    public int dfs(TreeNode root,int curSum){
        if(root == null) return 0;
        curSum += root.val;//得到当前前缀树的值
        int res = 0;
        res = mem.getOrDefault(curSum-target,0);//得到我们想要前缀树的个数，想要前缀树值就是当前前缀树值减去目标值
        mem.put(curSum,mem.getOrDefault(curSum,0)+1);//将当前前缀树的值保存
        int left = dfs(root.left,curSum);//遍历左边
        int right = dfs(root.right,curSum);//遍历右边
        mem.put(curSum,mem.get(curSum)-1);//防止左边前缀树影响右边前缀树，左边前缀树可能有个为6，右边正好想要一个前缀树为6的，这样子就出错了
        return res+left+right;//结果是当前节点前缀树的个数加上左边满足的个数加右边满足的个数
    }
}
