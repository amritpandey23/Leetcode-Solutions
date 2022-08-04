class Solution {
    public int minAddToMakeValid(String s) {
        int score = 0;
        int moves = 0;
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            if (ch == ')') {
                score--;
            } else {
                score++;
            }
            if (score < 0) {
                moves++;
                score = 0;
            }
        }
        return moves + Math.abs(score);
    }
}