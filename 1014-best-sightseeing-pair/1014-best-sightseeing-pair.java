class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int n, Ans;
        int[] dp;
        
        n = values.length;
        Ans = Integer.MIN_VALUE;
        dp = new int[n];
        
        dp[0] = values[0];
        
        for (int i = 1; i < n; ++i) {
            dp[i] = Math.max(dp[i - 1], values[i] + i);
        }
        
        for (int i = 1; i < n; ++i) {
            Ans = Math.max(Ans, values[i] - i + dp[i - 1]);
        }
        
        return Ans;
    }
}