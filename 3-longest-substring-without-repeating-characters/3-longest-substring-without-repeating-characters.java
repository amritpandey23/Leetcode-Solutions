class Solution {
    public int lengthOfLongestSubstring(String s) {
        int start, end, n, Ans;
        int[] map = new int[256];
        
        n = s.length();
        start = end = Ans = 0;
        
        for (end = 0; end < n; ++end) {
            char ch = s.charAt(end);
            map[ch]++;
            if (map[ch] > 1) {
                Ans = Math.max(Ans, end - start);
                while (map[ch] > 1) {
                    char chs = s.charAt(start);
                    map[chs]--;
                    start++;
                }
            }
        }
        
        Ans = Math.max(Ans, end - start);
        return Ans;
    }
}