class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[2][n + 1];
        for (int[] d : dp) {
            Arrays.fill(d, -1);
        }
        return solve(prices, 0, 0, -1000, dp);
    }
    
    private int solve(int[] A, int i, int bs, int currBuy, int[][] dp) {
        int n = A.length;
        if (i > n) {
            return 0;
        }
        if (dp[bs][i] != -1) {
            return dp[bs][i];
        }
        dp[bs][i] = 0;
        if (bs == 0) {
            for (int j = i; j < n; ++j) {
                dp[bs][i] = Math.max(dp[bs][i], solve(A, j + 1, 1, A[j], dp));
            }
        } else {
            for (int j = i; j < n; ++j) {
                int profit = A[j] - currBuy;
                if (profit > 0) {
                    dp[bs][i] = Math.max(dp[bs][i], profit + solve(A, j + 2, 0, -1000, dp));
                }
            }
        }
        return dp[bs][i];
    }
}