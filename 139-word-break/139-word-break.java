class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        HashSet<String> words = new HashSet<>(wordDict);
        Boolean[] dp = new Boolean[n + 1];
        return solve(s, 0, words, dp);
    }
    
    private boolean solve (String s, int start, HashSet<String> words, Boolean[] dp) {
        int n = s.length();
        if (start == n) {
            return true;
        }
        if (dp[start] != null) {
            return dp[start];
        }
        for (int end = start + 1; end <= n; ++end) {
            if (words.contains(s.substring(start, end)) &&
                    solve(s, end, words, dp)) {
                return dp[start] = true;
            }
        }
        return dp[start] = false;
    }
}