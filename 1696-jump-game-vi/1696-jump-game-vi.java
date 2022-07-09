class Solution {
    public int maxResult(int[] nums, int k) {
        int n = nums.length;
        int[] cost = new int[n];
        cost[n - 1] = nums[n - 1];
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> cost[b] - cost[a]);
        pq.offer(n - 1);
        for (int i = n - 2; i >= 0; --i) {
            int val = nums[i];
            while (pq.peek() > i + k) {
                pq.poll();
            }
            cost[i] = cost[pq.peek()] + val;
            pq.offer(i);
        }
        return cost[0];
    }
}