package tree;

import datastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class AllPossibleFullBinaryTrees894 {
    ArrayList<TreeNode>res=new ArrayList<>();
    public List<TreeNode> allPossibleFBT(int n) {
        if(n%2==0)return res;
        if(n==1)res.add(new TreeNode(0));
        for(int i=1;i+1<n;i+=2){
            List<TreeNode>left=allPossibleFBT(i),right=allPossibleFBT(n-i-1);
            for(TreeNode l:left){
                for(TreeNode r:right){
                    res.add(new TreeNode(0,l,r));
                }
            }
        }
        return res;
    }
}
