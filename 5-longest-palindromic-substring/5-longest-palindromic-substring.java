class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        String Ans = "";
        for (int i = 0; i < n; ++i) {
            String res1 = extendedPalindrome(s, i, i);
            String res2 = extendedPalindrome(s, i, i + 1);
            res1 = res1.length() > res2.length() ? res1 : res2;
            if (Ans.length() < res1.length()) {
                Ans = res1;
            }
        }
        return Ans;
    }
    
    private String extendedPalindrome(String s, int i, int j) {
        int n = s.length();
        while (i >= 0 && j < n && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        return s.substring(i + 1, j);
    }
}