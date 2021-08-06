package backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsII47 {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    boolean[] visit;

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        visit = new boolean[nums.length];
        dfs(nums, 0);
        return res;
    }

    public void dfs(int[] nums, int u) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!visit[i]) {
                if (i > 0 && nums[i - 1] == nums[i] && !visit[i - 1]) {
                    continue;
                }
                visit[i] = true;
                path.add(nums[i]);
                dfs(nums, u + 1);
                path.remove(path.size() - 1);
                visit[i] = false;
            }
        }
    }
}
