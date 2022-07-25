class Solution {
    public int countSubstrings(String s) {
        for (int i = 0; i < s.length(); ++i) {
            extendedPalindrome(s, i, i);
            extendedPalindrome(s, i, i + 1);
        }
        return count;
    }
    
    private int count = 0;
    
    private void extendedPalindrome(String s, int i, int j) {
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            count++;
            i--;
            j++;
        }
    }
}