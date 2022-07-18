/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    private Map<Integer, Node> visited = new HashMap<>();
    
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        Node newNode = new Node(node.val);
        visited.put(node.val, newNode);
        for (Node nbr : node.neighbors) {
            if (visited.containsKey(nbr.val)) {
                newNode.neighbors.add(visited.get(nbr.val));
            } else {
                newNode.neighbors.add(cloneGraph(nbr));
            }
        }
        return newNode;
    }
}