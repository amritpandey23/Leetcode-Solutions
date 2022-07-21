class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new List[numCourses];
        for (int i = 0; i < numCourses; ++i) {
            graph[i] = new ArrayList<>();
        }
        for (int[] x : prerequisites) {
            graph[x[0]].add(x[1]);
        }
        int[] indegrees = new int[numCourses];
        for (int vtx = 0; vtx < numCourses; ++vtx) {
            for (int nbr : graph[vtx]) {
                indegrees[nbr]++;
            }
        }
        ArrayDeque<Integer> Queue = new ArrayDeque<>();
        for (int vtx = 0; vtx < numCourses; ++vtx) {
            if (indegrees[vtx] == 0) {
                Queue.offer(vtx);
            }
        }
        int v = 0;
        while (!Queue.isEmpty()) {
            int curr = Queue.poll();
            v++;
            for (int nbr : graph[curr]) {
                indegrees[nbr]--;
                if (indegrees[nbr] == 0) {
                    Queue.offer(nbr);
                }
            }
        }
        return v == numCourses;
    }
}