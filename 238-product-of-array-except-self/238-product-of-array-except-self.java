class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n, pre;
        int[] Ans;
        
        n = nums.length;
        Ans = new int[n];
        
        Ans[n - 1] = 1;
        for (int i = n - 2; i >= 0; --i) {
            Ans[i] = nums[i + 1] * Ans[i + 1];
        }
        
        pre = 1;
        for (int i = 0; i < n; ++i) {
            Ans[i] *= pre;
            pre = nums[i] * pre;
        }
        
        return Ans;
    }
}