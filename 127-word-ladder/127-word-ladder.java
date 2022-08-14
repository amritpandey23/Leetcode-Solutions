class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> words = new HashSet<>(wordList);
        if (!words.contains(endWord)) {
            return 0;
        }
        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        beginSet.add(beginWord);
        endSet.add(endWord);
        int length = 1;
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            if (beginSet.size() > endSet.size()) {
                Set<String> tmp = beginSet;
                beginSet = endSet;
                endSet = tmp;
            }
            Set<String> newBeginSet = new HashSet<>();
            for (String word : beginSet) {
                List<String> neigh = neighbors(word);
                for (String nbr : neigh) {
                    if (endSet.contains(nbr)) {
                        return length + 1;
                    }
                    if (words.contains(nbr)) {
                        newBeginSet.add(nbr);
                        words.remove(nbr);
                    }
                }
            }
            beginSet = newBeginSet;
            length++;
        } 
        return 0;
    }
    
    private List<String> neighbors(String word) {
        int n = word.length();
        List<String> Ans = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            for (char j = 'a'; j <= 'z'; ++j) {
                char[] letters = word.toCharArray();
                letters[i] = j;
                String newWord = String.valueOf(letters);
                Ans.add(newWord);
            }
        }
        return Ans;
    }
}