class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n, pre;
        int[] suf, Ans;
        
        n = nums.length;
        suf = new int[n];
        Ans = new int[n];
        
        suf[n - 1] = 1;
        for (int i = n - 2; i >= 0; --i) {
            suf[i] = nums[i + 1] * suf[i + 1];
        }
        
        pre = 1;
        for (int i = 0; i < n; ++i) {
            Ans[i] = pre * suf[i];
            pre = nums[i] * pre;
        }
        
        return Ans;
    }
}