class Solution {
    public int minMoves2(int[] nums) {
        int count = 0;
        Arrays.sort(nums);
        int M = -1;
        int n = nums.length;
        if ((nums.length & 1) == 0) {
            M = (nums[(n - 1) / 2] + nums[n / 2]) / 2;
        } else {
            M = nums[n / 2];
        }
        for (int t : nums) {
            count += Math.abs(t - M);
        }
        return count;
    }
}