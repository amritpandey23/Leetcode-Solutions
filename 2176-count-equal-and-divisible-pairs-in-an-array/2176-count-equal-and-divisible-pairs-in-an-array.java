class Solution {
    public int countPairs(int[] nums, int k) {
        int n = nums.length;
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        for (int i = 0; i < n; ++i) {
            if (map.get(nums[i]) == null) {
                map.put(nums[i], new ArrayList<>());
            }
            map.get(nums[i]).add(i);
        }
        int Ans = 0;
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            List<Integer> indexes = entry.getValue();
            for (int i = 0; i < indexes.size(); ++i) {
                for (int j = i + 1; j < indexes.size(); ++j) {
                    if ((indexes.get(i) * indexes.get(j)) % k == 0) {
                        Ans++;
                    }
                }
            }
        }
        return Ans;
    }
}