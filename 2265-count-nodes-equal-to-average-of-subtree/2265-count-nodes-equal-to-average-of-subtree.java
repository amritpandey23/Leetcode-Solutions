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
    private int Ans = 0;
    
    public int averageOfSubtree(TreeNode root) {
        getCountSum(root);
        return Ans;
    }
    
    private Pair getCountSum(TreeNode root) {
        if (root == null) {
            return new Pair(0, 0);
        }
        Pair p = new Pair(1, root.val);
        Pair pl = getCountSum(root.left);
        Pair pr = getCountSum(root.right);
        p.count += pl.count + pr.count;
        p.sum += pl.sum + pr.sum;
        if ((p.sum / p.count) == root.val) {
            Ans++;
        }
        return p;
    }
    
    private class Pair {
        int count;
        int sum;
        
        public Pair(int count, int sum) {
            this.count = count;
            this.sum = sum;
        }
    }
}