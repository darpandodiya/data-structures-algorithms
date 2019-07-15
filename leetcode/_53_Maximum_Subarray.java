package leetcode;

//https://leetcode.com/problems/maximum-subarray/
public class _53_Maximum_Subarray {
    public int maxSubArray(int[] nums) {
        int maxSoFar = nums[0];
        int currMax = nums[0];

        for(int i=1; i<nums.length; i++) {
            currMax = Math.max(nums[i], currMax + nums[i]);
            maxSoFar = Math.max(currMax, maxSoFar);
        }

        return maxSoFar;
    }
}
