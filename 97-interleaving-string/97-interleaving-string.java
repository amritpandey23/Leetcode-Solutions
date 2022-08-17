class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int n, m;
        boolean[][] dp;
        
        n = s1.length();
        m = s2.length();
        if (n + m != s3.length()) {
            return false;
        }
        dp = new boolean[n + 1][m + 1];
        
        for (int i = n; i >= 0; --i) {
            for (int j = m; j >= 0; --j) {
                if (i == n && j == m) {
                    dp[i][j] = true;
                } else {
                    if (i < n && s1.charAt(i) == s3.charAt(i + j) && dp[i + 1][j]) {
                        dp[i][j] = true;
                    }
                    if (j < m && s2.charAt(j) == s3.charAt(i + j) && dp[i][j + 1]) {
                        dp[i][j] = true;
                    }
                }
            }
        }
        
        return dp[0][0];
    }
}