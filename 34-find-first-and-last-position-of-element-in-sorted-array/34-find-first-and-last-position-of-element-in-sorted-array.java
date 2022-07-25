class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = {-1, -1};
        int fo, lo, low, high;
        fo = lo = -1;
        // 0 0 0 0 1 1 1 1
        low = 0; high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target && (mid == 0 || nums[mid] != nums[mid - 1])) {
                fo = mid;
                break;
            }
            if (nums[mid] >= target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        low = 0; high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target && (mid == nums.length - 1 || nums[mid] != nums[mid + 1])) {
                lo = mid;
                break;
            }
            if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        ans[0] = fo;
        ans[1] = lo;
        return ans;
    }
}