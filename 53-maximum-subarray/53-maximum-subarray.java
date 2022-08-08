class Solution {
    public int maxSubArray(int[] nums) {
        int sum, max;
        max = Integer.MIN_VALUE;
        sum = 0;
        
        for (int i = 0; i < nums.length; i++) {
            sum = Math.max(sum + nums[i], nums[i]);
            max = Math.max(sum, max);
        }
        
        return max;
    }
}