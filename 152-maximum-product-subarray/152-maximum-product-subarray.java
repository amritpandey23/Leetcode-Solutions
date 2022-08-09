class Solution {
    public int maxProduct(int[] nums) {
        int n, currMax, currMin, Ans;
        
        n = nums.length;
        currMax = currMin = 1;
        Ans = nums[0];
        for (int x : nums) {
            Ans = Math.max(Ans, x);
        }
        
        for (int i = 0; i < n; ++i) {
            if (nums[i] == 0) {
                currMax = currMin = 1;
            } else {
                int tmp = currMax * nums[i];
                currMax = Math.max(nums[i], Math.max(currMax * nums[i], currMin * nums[i]));
                currMin = Math.min(nums[i], Math.min(tmp, currMin * nums[i]));
                Ans = Math.max(Ans, currMax);
            }
        }
        
        return Ans;
    }
}