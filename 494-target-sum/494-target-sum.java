class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return solve(nums, target, nums.length, target);
    }
    
    public int solve(int[] nums, int target, int n, int k) {
        if (n == 0 && k == 0) {
            return 1;
        }
        if (n == 0) {
            return 0;
        }
        return solve(nums, target, n - 1, k - nums[n - 1]) +
            solve(nums, target, n - 1, k + nums[n - 1]);
    }
}