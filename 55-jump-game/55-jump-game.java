class Solution {
    public boolean canJump(int[] nums) {
        int n, fth;
        
        n = nums.length;
        fth = n - 1;
        
        for (int i = n - 2; i >= 0; --i) {
            if (nums[i] + i >= fth) {
                fth = i;
            }
        }
        return fth == 0;
    }
}