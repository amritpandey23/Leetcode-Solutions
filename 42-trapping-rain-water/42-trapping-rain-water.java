class Solution {
    public int trap(int[] height) {
        int n, l, r, maxL, maxR, vol;
        
        n = height.length;
        l = 0;
        r = n - 1;
        n = height.length;
        maxL = height[l];
        maxR = height[r];
        l++;
        r--;
        vol = 0;
        
        while (l <= r) {
            if (maxL <= maxR) {
                vol += maxL - height[l] < 0 ? 0 : maxL - height[l];
                maxL = Math.max(maxL, height[l]);
                l++;
            } else {
                vol += maxR - height[r] < 0 ? 0 : maxR - height[r];
                maxR = Math.max(maxR, height[r]);
                r--;
            }
        }
        
        return vol;
    }
}