Peculiar Kind of question.
​
​
Idea: Print nodes at a depth k.
​
​
We have to find out the path from root to target. And as we go up one level we have decrease the value of to print k - i nodes away from nodes in path. To prevent same nodes printed twice, we pass nodes as block.