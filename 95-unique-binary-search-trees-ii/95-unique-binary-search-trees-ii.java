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
    public List<TreeNode> generateTrees(int n) {
        return generateTrees(1, n);
    }
    
    private List<TreeNode> generateTrees (int low, int high) {
        List<TreeNode> Ans = new ArrayList<>();
        if (low > high) {
            Ans.add(null);
            return Ans;
        }
        if (low == high) {
            Ans.add(new TreeNode(low));
            return Ans;
        }
        for (int i = low; i <= high; ++i) {
            List<TreeNode> leftTrees = generateTrees(low, i - 1);
            List<TreeNode> rightTrees = generateTrees(i + 1, high);
            for (TreeNode ln : leftTrees) {
                for (TreeNode rn : rightTrees) {
                    TreeNode r = new TreeNode(i);
                    r.left = ln;
                    r.right = rn;
                    Ans.add(r);
                }
            }
        }
        return Ans;
    }
}