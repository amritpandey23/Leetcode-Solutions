class Solution {
    public int rob(int[] nums) {
        int n;
        int[] dp1, dp2;
        
        n = nums.length;
        dp1 = new int[n];
        dp2 = new int[n];
        
        if (n == 1) {
            return nums[0];
        }
        if (n == 2) {
            return Math.max(nums[0], nums[1]);
        }
        
        dp1[0] = nums[0];
        dp1[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n - 1; ++i) {
            dp1[i] = Math.max(dp1[i - 1], nums[i] + dp1[i - 2]);
        }
        
        dp2[n - 1] = nums[n - 1];
        dp2[n - 2] = Math.max(nums[n - 1], nums[n - 2]);
        for (int i = n - 3; i > 0; --i) {
            dp2[i] = Math.max(dp2[i + 1], nums[i] + dp2[i + 2]);
        }
        
        return Math.max(dp1[n - 2], dp2[1]);
    }
}