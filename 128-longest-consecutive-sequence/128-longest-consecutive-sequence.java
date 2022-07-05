class Solution {
    public int longestConsecutive(int[] nums) {
        int Ans = 0;
        Set<Integer> set = new HashSet<>();
        for (int x : nums) {
            set.add(x);
        }
        for (int x : nums) {
            if (!set.contains(x - 1)) {
                int ctr = 0;
                while (set.contains(x)) {
                    x++;
                    ctr++;
                }
                Ans = Math.max(Ans, ctr);
            }
        }
        return Ans;
    }
}