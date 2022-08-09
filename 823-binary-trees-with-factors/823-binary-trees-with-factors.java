class Solution {
    public int numFactoredBinaryTrees(int[] arr) {
        int mod = (int) 1e9 + 7;
        int n = arr.length;
        Arrays.sort(arr);
        long[] dp = new long[n];
        Arrays.fill(dp, 1);
        
        Map<Integer, Integer> index = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            index.put(arr[i], i);
        }
        
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                if (arr[i] % arr[j] == 0) {
                    int next = arr[i] / arr[j];
                    if (index.containsKey(next)) {
                        dp[i] = (dp[i] + dp[j] * dp[index.get(next)]) % mod;
                    }
                }
            }
        }
        
        long ans = 0;
        for (long a : dp) ans += a;
        
        return (int) (ans % mod);
    }
}