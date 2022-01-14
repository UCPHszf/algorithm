package RandomAlgorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ArrayShuffle384 {

    int[] nums;
    int[] original;

    public ArrayShuffle384(int[] nums) {
        this.nums = nums;
        this.original = new int[nums.length];
        System.arraycopy(nums, 0, original, 0, nums.length);
    }

    public int[] reset() {
        System.arraycopy(original, 0, nums, 0, original.length);
        return nums;
    }

    public int[] shuffle() {
        int[] shuffled = new int[nums.length];
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < shuffled.length; i++) {
            list.add(nums[i]);
        }
        Random random = new Random();
        for (int i = 0; i < nums.length; i++) {
            int idx = random.nextInt(list.size());
            shuffled[i] = list.remove(idx);
        }
        System.arraycopy(shuffled, 0, nums, 0, nums.length);
        return nums;
    }
}
