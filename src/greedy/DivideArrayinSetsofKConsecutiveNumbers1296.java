package greedy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class DivideArrayinSetsofKConsecutiveNumbers1296 {
    public boolean isPossibleDivide(int[] nums, int k) {
        int n = nums.length;
        if (n % k != 0) return false;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        int[] keys = map.keySet().stream().mapToInt(Integer::valueOf).toArray();
        Arrays.sort(keys);
        for (int key : keys) {
            if (map.get(key) != 0) {
                int cntOfCurSmallestKey = map.get(key);
                for (int i = key; i < key + k; i++) {
                    if (map.containsKey(i) && map.get(i) >= cntOfCurSmallestKey) {
                        map.put(i, map.get(i) - cntOfCurSmallestKey);
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
