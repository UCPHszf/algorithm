package Math;

public class SquaresofaSortedArray977 {
    public int[] sortedSquares(int[] nums) {
        int[] res = new int[nums.length];
        int l = 0, r = nums.length - 1, idx = nums.length - 1;
        while (l <= r) {
            if (Math.abs(nums[l]) > nums[r])
                res[idx--] = (int) Math.pow(nums[l++], 2);
            else
                res[idx--] = (int) Math.pow(nums[r--],2);
        }
        System.out.println(idx);
        return res;
    }
}
