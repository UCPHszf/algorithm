package search;

public class FindtheSmallestDivisorGivenaThreshold1283 {

    boolean check(int[] nums, int threshold, int mid) {
        int sum = 0;
        for (int i : nums) {
            sum += (i + mid - 1) / mid;
        }
        return sum <= threshold;
    }

    public int smallestDivisor(int[] nums, int threshold) {
        int l = 1, r = 1000000 + 1;
        while (l < r) {
            int mid = l + r >> 1;
            if (check(nums, threshold, mid)) r = mid;
            else l = mid + 1;
        }
        return r;
    }
}
