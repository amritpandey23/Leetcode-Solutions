/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // found either of p or q first
        if (root.val == p.val || root.val == q.val) {
            return root;
        }
        // if p lies to left and q lies to right or vice-versa
        if (
            (root.val > p.val && root.val < q.val) ||
            (root.val < p.val && root.val > q.val)
        ) {
            return root;
        }
        // both p, q lies either to left or right subtrees
        if (root.val > p.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        return lowestCommonAncestor(root.right, p, q);
    }
}