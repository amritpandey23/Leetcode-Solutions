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
    int preIndex = 0;
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, inorder, 0, preorder.length - 1);
    }
    
    public TreeNode buildTree(int[] preorder, int[] inorder, int is, int ie) {
        if (is > ie) {
            return null;
        }
        int val = preorder[preIndex++];
        TreeNode root = new TreeNode(val);
        int inIdx = -1;
        for (int i = is; i <= ie; ++i) {
            if (inorder[i] == val) {
                inIdx = i;
                break;
            }
        }
        root.left = buildTree(preorder, inorder, is, inIdx - 1);
        root.right = buildTree(preorder, inorder, inIdx + 1, ie);
        return root;
    }
}