package backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PermutationsI46 {
    ArrayList<List<Integer>> res = new ArrayList<>();
    boolean visit[] = new boolean[21];
    int[] Path;

    public List<List<Integer>> permute(int[] nums) {
        Path = new int[nums.length];
        dfs(0, nums);
        return res;
    }

    private void dfs(int u, int[] nums) {
        if (u == Path.length) {
            res.add(Arrays.stream(Path).boxed().collect(Collectors.toList()));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!visit[nums[i] + 10]) {
                Path[i] = nums[i];
                visit[nums[i] + 10] = true;
                dfs(u + 1, nums);
                visit[nums[i] + 10] = false;
            }
        }
    }
}
