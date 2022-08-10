class Solution {
    public int maxProfit(int[] prices) {
        int minPrice, maxProfit;
        minPrice = Integer.MAX_VALUE;
        maxProfit = 0;
        
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else {
                maxProfit = Math.max(maxProfit, prices[i] - minPrice);
            }
        }
        
        return maxProfit;
    }
}