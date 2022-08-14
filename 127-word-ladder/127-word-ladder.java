class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> words = new HashSet<>(wordList);
        if (!words.contains(endWord)) {
            return 0;
        }
        ArrayDeque<String> Queue = new ArrayDeque<>();
        Queue.offer(beginWord);
        int level = 0;
        while (!Queue.isEmpty()) {
            level++;
            int size = Queue.size();
            for (int c = 0; c < size; ++c) {
                String curr = Queue.poll();
                if (curr.equals(endWord)) {
                    return level;
                }
                List<String> neigh = neighbors(curr);
                for (String nbr : neigh) {
                    if (words.contains(nbr)) {
                        Queue.offer(nbr);
                        words.remove(nbr);
                    }
                }
            }
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