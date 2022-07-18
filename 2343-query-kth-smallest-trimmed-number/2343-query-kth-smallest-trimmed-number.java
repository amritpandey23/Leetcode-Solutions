class Solution {
    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        int[] Ans = new int[queries.length];
        int k = 0;
        for (int[] q : queries) {
            Ans[k++] = kthSmallest(nums, q[1], q[0]);
        }
        return Ans;
    }
    
    private int kthSmallest(String[] A, int trim, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((p1, p2) -> p2.val.compareTo(p1.val) == 0 ? p2.idx - p1.idx : p2.val.compareTo(p1.val));
        for (int i = 0; i < A.length; ++i) {
            String num = A[i].substring(A[i].length() - trim);
            Pair p = new Pair(num, i);
            pq.offer(p);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.poll().idx;
    }
    
    private class Pair {
        String val;
        int idx;
        Pair(String val, int idx) {
            this.val = val;
            this.idx = idx;
        }
    }
}