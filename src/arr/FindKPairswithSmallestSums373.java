package arr;

import java.util.*;

public class FindKPairswithSmallestSums373 {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<List<Integer>> queue = new PriorityQueue<>(new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return (o1.get(0) + o1.get(1)) - (o2.get(0) + o2.get(1));
            }
        });
        int m = Math.min(nums1.length, k);
        int n = Math.min(nums2.length, k);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                queue.offer(new ArrayList<>(Arrays.asList(nums1[i], nums2[j])));
            }
        }
        for (int i = 0; i < k&&!queue.isEmpty(); i++) {
            res.add(queue.poll());
        }
        return res;
    }
}
