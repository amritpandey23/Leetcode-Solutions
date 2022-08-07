class Solution {
    public int jump(int[] nums) {
        int n;
        int[] dp;
        
        n = nums.length;
        dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        
        dp[0] = 0;
        
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                if (j + nums[j] >= i) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }
        return dp[n - 1];
    }
}