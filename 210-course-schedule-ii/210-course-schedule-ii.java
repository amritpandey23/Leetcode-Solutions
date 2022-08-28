class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int V = numCourses;
        int[] Ans = new int[V];
        int[] indegrees = new int[V];
        ArrayDeque<Integer> Queue = new ArrayDeque<>();
        ArrayList<Integer>[] graph = new ArrayList[V];
        for (int i = 0; i < V; ++i) {
            graph[i] = new ArrayList<>();
        }
        for (int[] p : prerequisites) {
            indegrees[p[0]]++;
            graph[p[1]].add(p[0]);
        }
        for (int v = 0; v < V; ++v) {
            if (indegrees[v] == 0) {
                Queue.offer(v);
            }
        }
        int k = 0;
        while (!Queue.isEmpty()) {
            int vtx = Queue.poll();
            V--;
            Ans[k++] = vtx;
            for (int nbr : graph[vtx]) {
                indegrees[nbr]--;
                if (indegrees[nbr] == 0) {
                    Queue.offer(nbr);
                }
            }
        }
        return V > 0 ? (new int[0]) : Ans;
    }
}