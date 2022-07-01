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
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> Ans = new ArrayList<>();
        List<TreeNode> path = new ArrayList<>();
        findPath(root, target, path);
        printKDown(target, k, Ans, null);
        for (int i = 1; i < path.size() && i <= k; i++) {
            printKDown(path.get(i), k - i, Ans, path.get(i - 1));
        }
        return Ans;
    }
    
    public void printKDown(TreeNode root, int k, List<Integer> Ans, TreeNode block) {
        if (root == null) {
            return;
        }
        if (k == 0) {
            Ans.add(root.val);
            return;
        }
        if (root.left != block) {
            printKDown(root.left, k - 1, Ans, block);
        }
        if (root.right != block) {
            printKDown(root.right, k - 1, Ans, block);
        }
    }
    
    public boolean findPath(TreeNode root, TreeNode target, List<TreeNode> path) {
        if (root == null) {
            return false;
        }
        if (root == target) {
            path.add(target);
            return true;
        }
        if (findPath(root.left, target, path)) {
            path.add(root);
            return true;
        }
        if (findPath(root.right, target, path)) {
            path.add(root);
            return true;
        }
        return false;
    }
}