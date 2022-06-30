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
    public int goodNodes(TreeNode root) {
        return goodNodes(root, -10000000);
    }
    
    public int goodNodes(TreeNode root, int prevValue) {
        if (root == null) {
            return 0;
        }
        if (root.val >= prevValue) {
            return 1 + goodNodes(root.left, Math.max(prevValue, root.val)) + goodNodes(root.right, Math.max(prevValue, root.val));
        }
        return goodNodes(root.left, Math.max(prevValue, root.val)) + goodNodes(root.right, Math.max(prevValue, root.val));
    }
}