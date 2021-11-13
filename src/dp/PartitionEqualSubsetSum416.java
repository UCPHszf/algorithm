package dp;

public class PartitionEqualSubsetSum416 {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (Integer i : nums) sum += i;
        if (sum % 2 == 0) return false;
        int[] f = new int[sum + 1];
        f[0] = 1;
        for (Integer i : nums) {
            for (int j = sum; j >= i; j--) {
                f[j] |= f[j - i];
            }
        }
        return f[sum + 1] == 1;
    }
}
