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
    int maxLevel = -1;
    
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> Ans = new ArrayList<>();
        rv(root, 0, Ans);
        return Ans;
    }
    
    public void rv(TreeNode root, int level, List<Integer> Ans) {
        if (root == null) {
            return;
        }
        if (level > maxLevel) {
            Ans.add(root.val);
            maxLevel = level;
        }
        rv(root.right, level + 1, Ans);
        rv(root.left, level + 1, Ans);
    }
}