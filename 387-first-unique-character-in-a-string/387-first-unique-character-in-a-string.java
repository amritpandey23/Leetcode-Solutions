class Solution {
    public int firstUniqChar(String s) {
        int[] map = new int[256];
        int res = -1;
        for (int i = 0; i < s.length(); i++) {
            map[s.charAt(i)] += 1;
        }
        for (int i = 0; i < map.length; i++) {
            if (map[i] == 1) {
                if (res == -1) {
                    res = s.indexOf(i);
                } else {
                    res = Math.min(s.indexOf(i), res);
                }
            }
        }
        return res;
    }
}