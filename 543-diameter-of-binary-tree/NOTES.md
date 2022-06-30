Idea: Find the max length between any two leaf nodes of the tree.
​
**Approach 1** : Find left and right height at a node in the tree. And calculate maximum. O(n^2)
​
​
**Approach 2** : Precomputer height of each node in tree in a hashmap and then run approach 1. O(N), S(N)
​
​
**Approach 3** : Normally traverse to calculate height and in the middle update the maximum diameter. O(N)