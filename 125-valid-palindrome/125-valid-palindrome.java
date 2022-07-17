class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); ++i) {
            if ((s.charAt(i) >= '0' && s.charAt(i) <= '9') || (s.charAt(i) >= 'a' && s.charAt(i) <= 'z')) {
                sb.append(s.charAt(i));
            }
        }
        return isPalindromeString(sb.toString());
    }
    
    private boolean isPalindromeString(String txt) {
        int i, j;
        i = 0;
        j = txt.length() - 1;
        while (i < j) {
            if (txt.charAt(i) != txt.charAt(j)) {
                break;
            }
            ++i;
            --j;
        }
        return i >= j;
    }
}