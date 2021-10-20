package hashmap;

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicatesinanArray442 {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i == nums[i] - 1) continue;
            else {
                if (nums[i] - 1 == nums[nums[i] - 1]) res.add(nums[i] - 1);
                else swap(nums, i, nums[i] - 1);
            }
        }
        return res;
    }

    void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}
