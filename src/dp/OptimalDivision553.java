package dp;

public class OptimalDivision553 {
    public String optimalDivision(int[] nums) {
        if (nums.length == 1) return String.valueOf(nums[0]);
        else if (nums.length == 2) return String.valueOf(nums[0]) + "/" + String.valueOf(nums[1]);
        String res = String.valueOf(nums[0]) + "/(";
        for (int i = 1; i < nums.length; i++) {
            res += String.valueOf(nums[i]);
            if (i != nums.length - 1)
                res += "/";
            else
                res += ")";
        }
        return res;
    }
}
