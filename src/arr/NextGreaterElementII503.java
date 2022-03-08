package arr;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElementII503 {

    class KV {
        int value;
        int idx;

        public KV(int value, int idx) {
            this.value = value;
            this.idx = idx;
        }
    }

    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int[] db = new int[20010];
        for (int i = 0; i < nums.length; i++) {
            db[i] = nums[i];
            db[i + n] = nums[i];
        }
        Stack<KV> s = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            while (!s.isEmpty() && nums[i] > s.peek().value) {
                res[s.peek().idx] = nums[i];
                s.pop();
            }
            s.push(new KV(nums[i], i));
        }

    }
}
