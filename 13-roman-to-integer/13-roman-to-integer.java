class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> map = Map.of(
            'I', 1,
            'V', 5,
            'X', 10,
            'L', 50,
            'C', 100,
            'D', 500,
            'M', 1000
        );
        
        int Ans = 0;
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            if (i != s.length() - 1) {
                char ch2 = s.charAt(i + 1);
                if (map.get(ch) < map.get(ch2)) {
                    Ans -= map.get(ch);
                } else {
                    Ans += map.get(ch);
                }
            } else {
                Ans += map.get(ch);
            }
        }
        
        return Ans;
    }
}