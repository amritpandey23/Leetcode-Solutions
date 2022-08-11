/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        ArrayDeque<Node> Queue;
        
        Queue = new ArrayDeque<>();
        Queue.offer(root);
        while (!Queue.isEmpty()) {
            int count = Queue.size();
            Node prev = null;
            for (int i = 0; i < count; ++i) {
                Node curr = Queue.poll();
                if (i != 0) {
                    prev.next = curr;
                }
                prev = curr;
                if (curr.left != null) {
                    Queue.offer(curr.left);
                }
                if (curr.right != null) {
                    Queue.offer(curr.right);
                }
            }
            prev.next = null;
        }
        
        return root;
    }
}