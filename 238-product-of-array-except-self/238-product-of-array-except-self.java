class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n;
        int[] pre, suf, Ans;
        
        n = nums.length;
        pre = new int[n];
        suf = new int[n];
        Ans = new int[n];
        
        pre[0] = 1;
        for (int i = 1; i < n; ++i) {
            pre[i] = nums[i - 1] * pre[i - 1];
        }
        
        suf[n - 1] = 1;
        for (int i = n - 2; i >= 0; --i) {
            suf[i] = nums[i + 1] * suf[i + 1];
        }
        
        for (int i = 0; i < n; ++i) {
            Ans[i] = pre[i] * suf[i];
        }
        
        return Ans;
    }
}