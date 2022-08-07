class Solution {
    private int mod = (int) 1e9 + 7;
    
    public int countVowelPermutation(int n) {
        int v;
        long[][] dp;
        
        v = 5;
        dp = new long[n + 1][v];
        
        for (int len = 0; len <= n; ++len) {
            for (int vow = 0; vow < v; ++vow) {
                if (len == 0) {
                    dp[len][vow] = 0;
                } else if (len == 1) {
                    dp[len][vow] = 1;
                } else {
                    switch(vow) {
                        case 0:
                            dp[len][vow] = (dp[len - 1][1] + dp[len - 1][2] + dp[len - 1][4]) % mod;
                            break;
                        case 1:
                            dp[len][vow] = (dp[len - 1][0] + dp[len - 1][2]) % mod;
                            break;
                        case 2:
                            dp[len][vow] = (dp[len - 1][1] + dp[len - 1][3]) % mod;
                            break;
                        case 3:
                            dp[len][vow] = dp[len - 1][2] % mod;
                            break;
                        case 4:
                            dp[len][vow] = (dp[len - 1][3] + dp[len - 1][2]) % mod;
                            break;
                    }
                }
            }
        }
        
        long Ans = 0;
        for (int vow = 0; vow < v; ++vow) {
            Ans = (Ans + dp[n][vow]) % mod;
        }
        return (int) Ans;
    }
}