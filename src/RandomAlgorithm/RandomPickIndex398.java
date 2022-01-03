package RandomAlgorithm;

import java.util.*;

public class RandomPickIndex398 {
    Map<Integer, List<Integer>> map;

    public RandomPickIndex398(int[] nums) {
        map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.get(nums[i]).add(i);
            } else {
                List<Integer> list = new ArrayList<>(List.of(nums[i]));
                map.put(nums[i], list);
            }
        }
    }

    public int pick(int target) {
        int c = -1, n = 0;
        System.out.println(map.get(1).get(0));
        for (int i = 0; i < map.get(target).size(); i++) {
            n++;
            if (new Random().nextInt(n + 1) % n == 0) c = map.get(target).get(i);
        }
        return c;
    }
}
