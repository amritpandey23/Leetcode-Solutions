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
    public int getMinimumDifference(TreeNode root) {
        int lastValue = 1000000;
        int minDiff = Integer.MAX_VALUE;
        ArrayDeque<TreeNode> Stack = new ArrayDeque<>();
        TreeNode curr = root;
        while (!Stack.isEmpty() || curr != null) {
            if (curr != null) {
                Stack.push(curr);
                curr = curr.left;
            } else {
                curr = Stack.pop();
                minDiff = Math.min(minDiff, Math.abs(lastValue - curr.val));
                lastValue = curr.val;
                curr = curr.right;
            }
        }
        return minDiff;
    }
}