package backtrack;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII216 {

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    boolean[] visit = new boolean[9];

    public List<List<Integer>> combinationSum3(int k, int n) {
        dfs(k, n, 0, 0);
        return res;
    }

    void dfs(int num_size, int target, int sum, int idx) {
        if (num_size == path.size() && sum == target) {
            res.add(new ArrayList<>(path));
        }
        for (int i = idx; i < 9; i++) {
            if (!visit[i]) {
                path.add(i);
                visit[i] = true;
                sum += i;
                dfs(num_size, target, sum, idx++);
                sum -= i;
                visit[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }

//    List<Integer> temp = new ArrayList<Integer>();
//    List<List<Integer>> ans = new ArrayList<List<Integer>>();
//
//    public List<List<Integer>> combinationSum3(int k, int n) {
//        dfs(1, 9, k, n);
//        return ans;
//    }
//
//    public void dfs(int cur, int n, int k, int sum) {
//        if (temp.size() + (n - cur + 1) < k || temp.size() > k) {
//            return;
//        }
//        if (temp.size() == k) {
//            int tempSum = 0;
//            for (int num : temp) {
//                tempSum += num;
//            }
//            if (tempSum == sum) {
//                ans.add(new ArrayList<Integer>(temp));
//                return;
//            }
//        }
//        temp.add(cur);
//        dfs(cur + 1, n, k, sum);
//        temp.remove(temp.size() - 1);
//        dfs(cur + 1, n, k, sum);
//    }
}
