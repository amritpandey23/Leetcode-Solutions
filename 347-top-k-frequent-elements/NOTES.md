**Approach 1** : Using only hashmap. We create a hashmap and store frequency of each element and then find out top K elements frequency wise. Time complexity: O(N^2).
​
**Approach 2** : Using Priority Queue & Pairs. We maintain a max-heap of Pairs(freq, element) and we return the top K elements frequency wise.
​
**Approach 3** : Using HashMap + Buckets. We collect the elements frequency wise in buckets and then going from highest frequency buckets to lowest we collect the elements in them. Return K elements like this.