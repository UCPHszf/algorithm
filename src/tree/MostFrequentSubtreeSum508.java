package tree;

import datastructure.TreeNode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class MostFrequentSubtreeSum508 {
    HashMap<Integer, Integer> map = new HashMap<>();

    public int[] findFrequentTreeSum(TreeNode root) {
        dfs(root);
        List<Integer>res=new ArrayList<>();
        int maxFreq=0;
        for(Integer k:map.keySet()){
            if(map.get(k)==maxFreq){
                res.add(k);
            }else if(map.get(k)>maxFreq){
                res.clear();
                res.add(k);
                maxFreq=map.get(k);
            }
        }
        System.out.println(map.size());
        return res.stream().mapToInt(Integer::valueOf).toArray();
    }

    public int dfs(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) {
            map.put(root.val, map.getOrDefault(root.val, 0) + 1);
            return root.val;
        }
        int left=dfs(root.left);
        int right=dfs(root.right);
        int val=left+right+root.val;
        map.put(val,map.getOrDefault(val,0)+1);
        return val;
    }
}
