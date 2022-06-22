package Math;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class SmallestKNumbers {
    public int[] smallestK(int[] arr, int k) {
        List<Integer> res = new ArrayList<>();
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int i : arr) q.add(i);
        for (int i = 0; i < k && !q.isEmpty(); i++) res.add(q.poll());
        return res.stream().mapToInt(Integer::valueOf).toArray();
    }
}
