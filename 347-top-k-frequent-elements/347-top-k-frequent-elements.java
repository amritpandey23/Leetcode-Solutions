class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n;
        int[] Ans;
        
        n = nums.length;
        Ans = new int[k];
        
        ArrayList<Integer>[] buckets = new ArrayList[n + 1];
        
        HashMap<Integer, Integer> countMap = new HashMap<>();
        
        for (int i = 0; i < n; ++i) {
            countMap.put(nums[i], countMap.getOrDefault(nums[i], 0) + 1);
        }
        
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            int freq = entry.getValue();
            int val = entry.getKey();
            if (buckets[freq] == null) {
                buckets[freq] = new ArrayList<>();
            }
            buckets[freq].add(val);
        }
        
        int j = 0;
        for (int i = n; i >= 0; --i) {
            if (buckets[i] != null) {
                for (int e : buckets[i]) {
                    Ans[j++] = e;
                }
                if (j == k) {
                    return Ans;
                }
            }
        }
        
        return Ans;
    }
}