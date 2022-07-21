**Approaches:**
​
1. **Disjoint Set(will fail)**: In a directed graph, we cannot detect cycle. Disjoint set can only be used in undirected graph.
​
2. **Topological sort(BFS)**: Used to detect cycle in directed graph.
​
3. **DFS**: detect cycle using dfs algorithm, use recStack to store the nodes that are already in the stack.