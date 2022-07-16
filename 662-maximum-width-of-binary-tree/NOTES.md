Very interesting questions.
​
The idea is simple, you need index/position of starting and ending nodes at each level. But how do you get them?
​
**Approach 1** : Traverse each level like a full binary tree and find out index of starting and ending nodes. But this will be 2^logN time complexity or simply O(N). We have limit of 3000 nodes given and with this we can actually find the distance between the two nodes. Space complexity will be O(2^logN). Passed 77/113 test cases.
​
**Approach 2** : Traverse tree in preorder and store the position of leftmost nodes at each level. We know that the array representation of a tree is like:
left child = `i*2`
right child = `i* 2 + 1`
so at each level we will store the position of left index and then calculate the maxDepth with each right child node position.