class Solution {
    public int countPairs(int[] nums, int k) {
        int n = nums.length;
        List<int[]> divisiblePairs = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if ((i * j) % k == 0) {
                    divisiblePairs.add(new int[]{i, j});
                }
            }
        }
        int Ans = 0;
        for (int[] d : divisiblePairs) {
            if (nums[d[0]] == nums[d[1]]) {
                Ans++;
            }
        }
        return Ans;
    }
}