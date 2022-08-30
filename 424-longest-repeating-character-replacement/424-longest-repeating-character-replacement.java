class Solution {
    public int characterReplacement(String s, int k) {
        int start, end, n, Ans, ws;
        char mc, ch, sc;
        int[] map;
        
        n = s.length();                                         // length of string
        map = new int[26];                                      // direct table map
        start = end = 0;                                        // start, end pointers
        mc = '-';                                               // max frequency character
        ws = 0;
        Ans = 0;
        
        for (end = 0; end < n; ++end) {
            ch = s.charAt(end);
            map[ch - 'A']++;
            ws = end - start + 1;
            mc = mc == '-' || map[mc - 'A'] < map[ch - 'A'] ? ch : mc;
            if (ws - map[mc - 'A'] > k) {
                sc = s.charAt(start++);
                map[sc - 'A']--;
            }
            ws = end - start + 1;
            Ans = Math.max(Ans, ws);
        }
        
        return Ans;
    }
}