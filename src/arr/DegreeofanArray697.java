package arr;

import java.util.HashMap;
import java.util.Map;

public class DegreeofanArray697 {

    public int findShortestSubArray(int[] nums) {
        Map<Integer, int[]> map = new HashMap<>();
        int maxDegree = 0;
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], new int[]{i, i, 1});
            } else {
                map.get(nums[i])[1] = i;
                map.get(nums[i])[2]++;
            }
        }

        for (int[] tuple : map.values()) {
            if (tuple[2] == maxDegree) {
                res = Math.min(tuple[1] - tuple[0], res);
            }
            if (tuple[2] > maxDegree) {
                res = tuple[1] - tuple[0];
            }
        }
        return res;
    }
}
