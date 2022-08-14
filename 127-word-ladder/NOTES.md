**Approach 1** : Simple BFS. For each word generate all possible words which are at distance 1 from that word beginning from beginWord. Words in wordList will be added to the queue. Count levels till you reach the end word.
​
​
**Approach 2** : Bi-directional BFS. Search for both beginWord and endWord simultaenously. This implementation is new so remember it.