package hashmap;

import java.util.HashMap;

public class SubarraySumsDivisiblebyK974 {
    public int subarraysDivByK(int[] nums, int k) {
        int[] sum = new int[nums.length + 1];
        for (int i = 1; i <= nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i-1];
        }
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 1; i <= nums.length; i++) {
            int extra = (sum[i] % k + k) % k;
            res += map.getOrDefault(extra, 0);
            map.put(extra, map.getOrDefault(extra, 0) + 1);
        }
        return res;
    }
}
