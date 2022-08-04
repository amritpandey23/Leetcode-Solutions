class Solution {
    public int numOfPairs(String[] nums, String target) {
        HashMap<String, Integer> map = new HashMap<>();
        int n, Ans;
        n = nums.length;
        Ans = 0;
        for (int i = 0; i < n; ++i) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        for (int i = 0; i < target.length(); ++i) {
            String str1 = target.substring(0, i + 1);
            String str2 = target.substring(i + 1);
            if (map.get(str1) != null && map.get(str2) != null) {
                if (str1.equals(str2)) {
                    Ans += map.get(str1) * (map.get(str1) - 1);
                } else {
                    Ans += map.get(str1) * map.get(str2);
                }
            }
        }
        return Ans;
    }
}