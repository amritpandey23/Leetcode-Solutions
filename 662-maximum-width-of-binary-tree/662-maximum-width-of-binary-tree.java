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
    public int widthOfBinaryTree(TreeNode root) {
        findMaxWidth(root, 0, 0);
        return maxWidth;
    }
    
    int maxWidth = 0;
    
    private Map<Integer, Integer> leftMost = new HashMap<>();
    
    private void findMaxWidth(TreeNode root, int position, int depth) {
        if (root == null) {
            return;
        }
        if (!leftMost.containsKey(depth)) {
            leftMost.put(depth, position);
        }
        maxWidth = Math.max(maxWidth, position - leftMost.get(depth) + 1);
        findMaxWidth(root.left, position * 2, depth + 1);
        findMaxWidth(root.right, position * 2 + 1, depth + 1);
    }
}