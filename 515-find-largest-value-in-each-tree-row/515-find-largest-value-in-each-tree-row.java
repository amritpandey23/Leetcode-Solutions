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
    public List<Integer> largestValues(TreeNode root) {
        if (root == null) {
            return new ArrayList<Integer>();
        }
        List<Integer> Ans = new ArrayList<>();
        ArrayDeque<TreeNode> Queue = new ArrayDeque<>();
        Queue.offer(root);
        while (!Queue.isEmpty()) {
            int size = Queue.size();
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < size; ++i) {
                TreeNode curr = Queue.poll();
                max = Math.max(max, curr.val);
                if (curr.left != null) {
                    Queue.offer(curr.left);
                }
                if (curr.right != null) {
                    Queue.offer(curr.right);
                }
            }
            Ans.add(max);
        }
        return Ans;
    }
}