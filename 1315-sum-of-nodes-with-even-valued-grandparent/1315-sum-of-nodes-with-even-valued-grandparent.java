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
    public int sumEvenGrandparent(TreeNode root) {
        int Ans = 0;
        if (root == null) {
            return Ans;
        }
        if (root.val % 2 == 0) {
            Ans = sum(root, 2);
        }
        return Ans += sumEvenGrandparent(root.left) + sumEvenGrandparent(root.right);
    }
    
    private int sum(TreeNode root, int depth) {
        if (root == null) {
            return 0;
        }
        if (depth == 0) {
            return root.val;
        }
        return sum(root.left, depth - 1) + sum(root.right, depth - 1);
    }
}