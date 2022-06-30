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
    public void recoverTree(TreeNode root) {
        List<Integer> values = new ArrayList<>();
        List<TreeNode> nodes = new ArrayList<>();
        ArrayDeque<TreeNode> Stack = new ArrayDeque<>();
        TreeNode curr = root;
        while (!Stack.isEmpty() || curr != null) {
            if (curr != null) {
                Stack.push(curr);
                curr = curr.left;
            } else {
                curr = Stack.pop();
                values.add(curr.val);
                nodes.add(curr);
                curr = curr.right;
            }
        }
        Collections.sort(values);
        for (int i = 0; i < values.size(); i++) {
            nodes.get(i).val = values.get(i);
        }
    }
}