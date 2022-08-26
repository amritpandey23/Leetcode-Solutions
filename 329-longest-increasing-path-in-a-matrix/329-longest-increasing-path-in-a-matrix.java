class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];
        for (int[] d : dp) {
            Arrays.fill(d, -1);
        }
        int Ans = Integer.MIN_VALUE;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                Ans = Math.max(Ans, longestIncreasingPath(matrix, i, j, dp));
            }
        }
        return Ans;
    }
    
    public int longestIncreasingPath(int[][] matrix, int i, int j, int[][] dp) {
        int n = matrix.length;
        int m = matrix[0].length;
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        dp[i][j] = 1;
        if (i < n - 1 && matrix[i + 1][j] > matrix[i][j]) {
            dp[i][j] = Math.max(dp[i][j], 1 + longestIncreasingPath(matrix, i + 1, j, dp));
        }
        if (i > 0 && matrix[i - 1][j] > matrix[i][j]) {
            dp[i][j] = Math.max(dp[i][j], 1 + longestIncreasingPath(matrix, i - 1, j, dp));
        }
        if (j < m - 1 && matrix[i][j + 1] > matrix[i][j]) {
            dp[i][j] = Math.max(dp[i][j], 1 + longestIncreasingPath(matrix, i, j + 1, dp));
        }
        if (j > 0 && matrix[i][j - 1] > matrix[i][j]) {
            dp[i][j] = Math.max(dp[i][j], 1 + longestIncreasingPath(matrix, i, j - 1, dp));
        }
        return dp[i][j];
    }
}