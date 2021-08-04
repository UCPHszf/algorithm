package Math;

import java.util.Arrays;

public class LargestPerimeterTriangle976 {
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        for(int i=nums.length-2;i>=1;i--){
            if(nums[i-1]+nums[i]>nums[i+1])
                return nums[i-1]+nums[i]+nums[i+1];
        }
        return 0;
    }
}
