class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        return uniquePaths(0, 0, m, n, dp);
    }
    
    public int uniquePaths(int row, int col, int m, int n, int[][] dp) {
        if (row == m || col == n) {
            return 0;
        }
        if (row == m - 1 && col == n - 1) {
            return 1;
        }
        if (dp[row][col] > 0) {
            return dp[row][col];
        }
        dp[row][col] = uniquePaths(row + 1, col, m, n, dp) + uniquePaths(row, col + 1, m, n, dp);
        return dp[row][col];
    }
}