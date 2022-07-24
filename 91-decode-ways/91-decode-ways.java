class Solution {
    public int numDecodings(String s) {
        int n;
        int[] dp;
        
        n = s.length();
        dp = new int[n];
        
        if (s.charAt(0) == '0') {
            return 0;
        }
        
        dp[0] = 1;
        for (int i = 1; i < n; ++i) {
            char l2 = s.charAt(i - 1);
            char l1 = s.charAt(i);
            if (l1 == '0' && l2 == '0') {
                dp[i] = 0;
            } else if (l1 == '0' && l2 != '0') {
                int x = Integer.parseInt(s.substring(i - 1, i + 1));
                if (x <= 26) {
                    if (i > 1) {
                        dp[i] = dp[i - 2];
                    } else {
                        dp[i]++;
                    }
                }
            } else if (l1 != '0' && l2 == '0') {
                dp[i] = dp[i - 1];
            } else {
                dp[i] = dp[i - 1];
                int x = Integer.parseInt(s.substring(i - 1, i + 1));
                if (x <= 26) {
                    if (i > 1) {
                        dp[i] += dp[i - 2];
                    } else {
                        dp[i]++;
                    }
                }
            }
        }
        
        return dp[n - 1];
    }
}