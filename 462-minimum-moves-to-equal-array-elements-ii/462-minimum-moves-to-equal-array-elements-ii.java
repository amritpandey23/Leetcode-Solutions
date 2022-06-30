class Solution {
    public int minMoves2(int[] nums) {
        int count = 0;
        Arrays.sort(nums);
        int M = -1;
        if ((nums.length & 1) == 0) {
            int x = nums[(nums.length - 1) / 2];
            int y = nums[(nums.length) / 2];
            M = (x + y) / 2;
        } else {
            M = nums[nums.length / 2];
        }
        for (int n : nums) {
            count += Math.abs(n - M);
        }
        return count;
    }
}