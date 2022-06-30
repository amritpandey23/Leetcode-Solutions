Idea: First one may think to solve this problem by taking average of the elements and then using it find total steps. But this hypothesis fails. But if one takes median instead of mean, it works. So the problem is to find Median and then count steps.
​
Approach 1 : Sorting the array and finding the median. O(nLogn)
​
Approach 2 : Using quickSelect to find Median O(logN) + O(N) space.