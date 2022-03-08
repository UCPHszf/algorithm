package arr;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElementI496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        Stack<Integer> s = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.fill(res, -1);
        for (int i = 0; i < nums1.length; i++) {
            map.put(nums1[i], i);
        }
        for (int i = 0; i < nums2.length; i++) {
            while (!s.isEmpty() && nums2[i] > s.peek()) {
                if (map.containsKey(s.peek())) {
                    res[map.get(s.peek())] = nums2[i];
                }
                s.pop();
            }
            s.add(nums2[i]);
        }
        return res;
    }
}
