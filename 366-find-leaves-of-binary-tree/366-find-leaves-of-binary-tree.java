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
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> Ans = new ArrayList<>();
        while (root != null) {
            List<Integer> r = new ArrayList<>();
            boolean res = solve(root, r);
            Ans.add(r);
            if (res) {
                root = null;
            }
        }
        return Ans;
    }
    
    private boolean solve(TreeNode root, List<Integer> Ans) {
        if (root == null) {
            return false;
        }
        
        if (isLeaf(root)) {
            Ans.add(root.val);
            return true;
        }
        
        boolean ls = solve(root.left, Ans);
        boolean rs = solve(root.right, Ans);
        
        if (ls) {
            root.left = null;
        }
        
        if (rs) {
            root.right = null;
        }
        
        return false;
    }
    
    private boolean isLeaf(TreeNode root) {
        return root != null && root.left == null && root.right == null;
    }
}