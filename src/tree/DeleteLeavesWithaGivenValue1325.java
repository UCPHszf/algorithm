package tree;

import datastructure.TreeNode;

public class DeleteLeavesWithaGivenValue1325 {
    void dfs(TreeNode root, TreeNode father, char direction, int target){
        if(root==null)return;
        if(root.val==target){
            boolean isDel= dfs2(root.left,target)&&dfs2(root.right,target);
            if(isDel){
                if(direction=='L'){
                    father.left=null;
                }else{
                    father.right=null;
                }
            }
        }
        dfs(root.left,root,'L',target);
        dfs(root.right,root,'R',target);
    }

    boolean dfs2(TreeNode node,int target){
        if(node==null)return true;
        else{
            if(node.val!=target)return false;
            else{
                if(node.left==null&&node.right==null){
                    return true;
                }
                return dfs2(node.left,target)&&dfs2(node.right,target);
            }
        }
    }

    public TreeNode removeLeafNodes(TreeNode root, int target) {
        TreeNode dummy=new TreeNode(-1);
        dummy.left=root;
        dfs(dummy.left,dummy,'L',target);
        return dummy.left;
    }
}
