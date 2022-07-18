class Solution {
    public int subarraySum(int[] nums, int k) {
        int Ans = 0, preSum = 0, n = nums.length;
        Map<Integer, Integer> preSumMap = new HashMap<>();
        preSumMap.put(0, 1); // if the presum == k, then we need this.
        for (int i = 0; i < n; ++i) {
            preSum += nums[i];
            Ans += preSumMap.getOrDefault(preSum - k, 0);
            preSumMap.put(preSum, preSumMap.getOrDefault(preSum, 0) + 1);
        }
        return Ans;
    }
}