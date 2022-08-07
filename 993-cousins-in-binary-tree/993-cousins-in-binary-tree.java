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
    TreeNode parentX = null;
    TreeNode parentY = null;
    int depthX = -1;
    int depthY = -1;
    
    public boolean isCousins(TreeNode root, int x, int y) {
        find(root, null, x, y, 0);
        return (depthX == depthY && parentX != parentY);
    }
    
    private void find(TreeNode root, TreeNode parent, int x, int y, int d) {
        if (root == null) {
            return;
        }
        if (root.val == x || root.val == y) {
            if (root.val == x) {
                parentX = parent;
                depthX = d;
            } else {
                parentY = parent;
                depthY = d;
            }
            return;
        }
        find(root.left, root, x, y, d + 1);
        find(root.right, root, x, y, d + 1);
    }
}