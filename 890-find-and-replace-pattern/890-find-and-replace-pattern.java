class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> Ans = new ArrayList<>();
        for (String word : words) {
            if (doesMap(word, pattern)) {
                Ans.add(word);
            }
        }
        return Ans;
    }
    
    private boolean doesMap(String word, String pattern) {
        char[] map = new char[26];
        char[] map2 = new char[26];
        Arrays.fill(map, '-');
        Arrays.fill(map2, '-');
        int n = word.length();
        for (int i = 0; i < n; ++i) {
            char wch = word.charAt(i);
            char pch = pattern.charAt(i);
            if (map[wch - 'a'] != '-' && map[wch - 'a'] != pch) {
                return false;
            }
            if (map2[pch - 'a'] != '-' && map2[pch - 'a'] != wch) {
                return false;
            }
            map[wch - 'a'] = pch;
            map2[pch - 'a'] = wch;
        }
        return true;
    }
}