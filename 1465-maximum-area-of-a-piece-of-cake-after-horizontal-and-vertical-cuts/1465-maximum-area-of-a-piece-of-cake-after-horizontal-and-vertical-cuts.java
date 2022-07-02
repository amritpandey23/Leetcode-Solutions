class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        int mod = (int) 1e9 + 7;
        int maxH = 0;
        int maxV = 0;
        int startH, startV;
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        startH = startV = 0;
        
        for (int t : horizontalCuts) {
            maxH = Math.max(maxH, t - startH);
            startH = t;
        }
        maxH = Math.max(maxH, h - startH) % mod;
        
        for (int t : verticalCuts) {
            maxV = Math.max(maxV, t - startV);
            startV = t;
        }
        maxV = Math.max(maxV, w - startV) % mod;
        // System.out.println("maxH = " + maxH + " maxV = " + maxV);
        return new Long(((long) maxH * (long) maxV) % mod).intValue();
    }
}