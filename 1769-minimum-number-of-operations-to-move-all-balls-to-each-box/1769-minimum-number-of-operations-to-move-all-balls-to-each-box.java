class Solution {
    public int[] minOperations(String boxes) {
        int n;
        int[] Ans;
        TreeSet<Integer> set;
        
        n = boxes.length();
        Ans = new int[n];
        set = new TreeSet<>();
        for (int i = 0; i < n; ++i) {
            if (boxes.charAt(i) == '1') {
                set.add(i);
            }
        }
        for (int i = 0; i < n; ++i) {
            for (int bi : set) {
                Ans[i] += Math.abs(i - bi);
            }
        }
        return Ans;
    }
}