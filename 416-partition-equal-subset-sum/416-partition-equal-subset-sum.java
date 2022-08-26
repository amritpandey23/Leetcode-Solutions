class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int x : nums) {
            sum += x;
        }
        if (sum % 2 != 0) {
            return false;
        }
        sum /= 2;
        Boolean[][] dp = new Boolean[sum + 1][nums.length + 1];
        return subsetSum(nums, sum, nums.length, dp);
    }
    
    private boolean subsetSum(int[] nums, int sum, int n, Boolean[][] dp) {
        if (n == 0 || sum < 0) {
            return false;
        }
        if (sum == 0) {
            return true;
        }
        if (dp[sum][n] != null) {
            return dp[sum][n];
        }
        return dp[sum][n] = 
            subsetSum(nums, sum - nums[n - 1], n - 1, dp) || 
            subsetSum(nums, sum, n - 1, dp);
    }
}