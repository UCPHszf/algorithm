package unionFind;

import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class LargestComponentSizebyCommonFactor952 {
    int[] parent;
    int[] rank;

    public int largestComponentSize(int[] nums) {
        parent = new int[nums.length];
        rank = new int[nums.length];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (coprime(nums[i], nums[j])) {
                    merge(i, j);
                }
            }
        }
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int i = 0; i < parent.length; i++) {
            int t = find(i);
            cnt.put(t, cnt.getOrDefault(t, 0) + 1);
        }
        return cnt.values().stream().sorted((o1, o2) -> o2 - o1).findFirst().get();
    }

    public int find(int x) {
        if (parent[x] == x) return x;
        else {
            parent[x] = find(parent[x]);
            return parent[x];
        }
    }

    public void merge(int x, int y) {
        int parentX = find(x);
        int parentY = find(y);
        if (parentX == parentY) return;
        if (rank[parentX] > rank[parentY]) {
            parent[parentY] = parentX;
        } else {
            parent[parentX] = parentY;
        }
        if (rank[parentX] == rank[parentY]) rank[parentX]++;
    }

    private int gcd(int p, int q) {
        if (q == 0) {
            return p;
        }
        return gcd(q, p % q);
    }

    private boolean coprime(int p, int q) {
        return (gcd(p, q) == 1);
    }
}
