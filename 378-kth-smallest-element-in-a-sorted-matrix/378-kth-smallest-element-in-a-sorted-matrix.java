class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer> () {
            public int compare(Integer a, Integer b) {
                return b - a;
            }
        });
        
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (pq.size() < k) {
                    pq.offer(matrix[i][j]);
                } else {
                    int x = pq.poll();
                    if (x > matrix[i][j]) {
                        pq.offer(matrix[i][j]);
                    } else {
                        pq.offer(x);
                    }
                }
            }
        }
        return pq.poll();
    }
}