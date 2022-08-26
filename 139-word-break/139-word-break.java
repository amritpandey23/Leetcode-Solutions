class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> words = new HashSet<>(wordDict);
        Boolean[] dp = new Boolean[s.length()];
        return wordBreak(s, words, 0, dp);
    }
    
    private boolean wordBreak(String s, Set<String> wordDict, int start, Boolean[] dp) {
        if (start == s.length()) {
            return true;
        }
        if (dp[start] != null) {
            return dp[start];
        }
        for (int end = start + 1; end <= s.length(); ++end) {
            if (wordDict.contains(s.substring(start, end)) 
                    && wordBreak(s, wordDict, end, dp)) {
                return dp[start] = true;
            }
        }
        return dp[start] = false;
    }
}