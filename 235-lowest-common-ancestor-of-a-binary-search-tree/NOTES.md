Idea: Find out the nearest ancestor common to both the nodes.
​
​
Approach 1 : Create a path of ancestor of both the nodes. And find out the lowest common ancestor of both the nodes.
​
​
Approach 2 : Traverse the BST. Following scenarios will come into play:
​
- You found one of the nodes (p or q) will traversing.
- You found a node where p lies to it's left and q lies to its right or vice versa.
- Both p and q are lying either on left or right.
​
In first two cases the current node itself is the answer.