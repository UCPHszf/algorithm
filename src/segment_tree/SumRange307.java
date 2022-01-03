package segment_tree;

public class SumRange307 {

    int n;
    int[] tr, _nums;

    int lowbit(int x) {
        return x & -x;
    }

    int query(int x) {
        int res = 0;
        for (int i = x; i > 0; i -= lowbit(x)) {
            res += tr[i];
        }
        return res;
    }

    void add(int x, int v) {
        for (int i = x; i <= n; i += lowbit(x)) {
            tr[i] += v;
        }
    }

    public SumRange307(int[] nums) {
        n = nums.length;
        tr = new int[n + 1];
        _nums = nums;
        for (int i = 0; i < n; i++) {
            add(i + 1, nums[i]);
        }
    }

    public void update(int index, int val) {
        add(index + 1, val - _nums[index]);
        _nums[index] = val;
    }

    public int sumRange(int left, int right) {
        return query(right + 1) - query(left);
    }
}
