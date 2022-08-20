**Approach 1** : Calculate product of entire array. If there are two zeros then the answer contains all the 0. If the array contains 1 zero then the answer will have product > 0 at 0th place. Else for each element we do product/element. O(N) time, O(1) space.
​
**Approach 2** : Create prefix and suffix product array. For each element calculate prefix[i] * suffix[i]. O(N) time, O(N) space.
​
**Approach 3** : Only create suffix product array in the output array itself. Maintain pre variable that store prefix product value at each index. Ans[i] = Ans[i] * pre. O(N) time, O(1) space.