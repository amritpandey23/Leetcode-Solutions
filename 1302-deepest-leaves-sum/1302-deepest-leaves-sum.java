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
    private int depth = -1;
    private int sum = 0;
    public int deepestLeavesSum(TreeNode root) {
        dls(root, 0);
        return sum;
    }
    
    public void dls(TreeNode root, int d) {
        if (root == null) {
            return;
        }
        if (d > depth) {
            depth = d;
            sum = root.val;
        } else if (d == depth) {
            sum += root.val;
        }
        dls(root.left, d + 1);
        dls(root.right, d + 1);
    }
}