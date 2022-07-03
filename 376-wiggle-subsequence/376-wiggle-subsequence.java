class Solution {
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        int[] up = new int[n];
        int[] down = new int[n];
        up[n - 1] = 1;
        down[n - 1] = 1;
        for (int i = n - 2; i >= 0; --i) {
            // looking for smaller element in up
            for (int j = i + 1; j < n; j++) {
                if (nums[i] > nums[j]) {
                    down[i] = Math.max(down[i], up[j]);   
                }
            }
            down[i] += 1;
            // looking for greater element in down 
            for (int j = i + 1; j < n; j++) {
                if (nums[i] < nums[j]) {
                    up[i] = Math.max(up[i], down[j]);
                }
            }
            up[i] += 1;
        }
        int Ans = 0;
        for (int i = 0; i < n; i++) {
            Ans = Math.max(Ans, Math.max(up[i], down[i]));
        }
        return Ans;
    }
}