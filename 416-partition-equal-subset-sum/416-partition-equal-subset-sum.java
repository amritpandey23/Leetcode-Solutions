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
        Boolean[][] dp = new Boolean[nums.length + 1][sum + 1];
        for (int i = 0; i <= nums.length; ++i) {
            for (int j = 0; j <= sum; ++j) {
                if (i == 0 && j == 0) {
                    dp[i][j] = true;
                } else if (i == 0 || j == 0) {
                    dp[i][j] = false;
                } else {
                    dp[i][j] = dp[i - 1][j];
                    if (nums[i - 1] <= j) {
                        dp[i][j] = dp[i][j] || dp[i - 1][j - nums[i - 1]];
                    }
                }
            }
        }
        return dp[nums.length][sum];
    }
}