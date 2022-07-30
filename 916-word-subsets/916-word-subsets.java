class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> Ans = new ArrayList<>();
        int[] maxMap = maxOccuranceOfChars(words2);
        for (String word : words1) {
            if (doesMatch(word, maxMap)) {
                Ans.add(word);
            }
        }
        return Ans;
    }
    
    private int[] maxOccuranceOfChars(String[] words) {
        int[] Ans = new int[26];
        for (String word : words) {
            int[] map = new int[26];
            for (int i = 0; i < word.length(); ++i) {
                char ch = word.charAt(i);
                map[ch - 'a']++;
                Ans[ch - 'a'] = Math.max(Ans[ch - 'a'], map[ch - 'a']);
            }
        }
        return Ans;
    }
    
    private boolean doesMatch(String word, int[] maxMap) {
        int[] map = new int[26];
        for (int i = 0; i < word.length(); ++i) {
            char ch = word.charAt(i);
            map[ch - 'a']++;
        }
        for (int i = 0; i < 26; ++i) {
            if (map[i] < maxMap[i]) {
                return false;
            }
        }
        return true;
    }
}