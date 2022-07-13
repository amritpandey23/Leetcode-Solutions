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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> Ans = new ArrayList<>();
        if (root == null) {
            return Ans;
        }
        ArrayDeque<TreeNode> Queue = new ArrayDeque<>();
        Queue.offer(root);
        while (!Queue.isEmpty()) {
            int count = Queue.size();
            List<Integer> lot = new ArrayList<>();
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
            Ans.add(lot);
        }
        return Ans;
    }
}