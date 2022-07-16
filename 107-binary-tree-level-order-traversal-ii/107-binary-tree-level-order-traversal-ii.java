/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) {
            return new ArrayList<List<Integer>>();
        }
        ArrayDeque<List<Integer>> Stack = new ArrayDeque<>();
        ArrayDeque<TreeNode> Queue = new ArrayDeque<>();
        Queue.offer(root);
        while (!Queue.isEmpty()) {
            List<Integer> lot = new ArrayList<>();
            int count = Queue.size();
            for (int i = 0; i < count; ++i) {
                TreeNode curr = Queue.poll();
                lot.add(curr.val);
                if (curr.left != null) {
                    Queue.offer(curr.left);
                }
                if (curr.right != null) {
                    Queue.offer(curr.right);
                }
            }
            Stack.push(lot);
        }
        return new ArrayList<List<Integer>>(Stack);
    }
}