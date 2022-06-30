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
        List<TreeNode> path1 = new ArrayList<>();
        List<TreeNode> path2 = new ArrayList<>();
        constructPath(path1, root, p);
        constructPath(path2, root, q);
        int i, j;
        i = path1.size() - 1;
        j = path2.size() - 1;
        while (i >= 0 && j >= 0) {
            if (path1.get(i).val != path2.get(j).val) {
                return path1.get(i + 1);
            }
            i--;
            j--;
        }
        if (i < 0) {
            return path1.get(0);
        }
        return path2.get(0);
    }
    
    private boolean constructPath(List<TreeNode> path, TreeNode root, TreeNode sn) {
        if (root == null) {
            return false;
        }
        if (root == sn) {
            path.add(root);
            return true;
        }
        boolean isOnLeft = constructPath(path, root.left, sn);
        if (isOnLeft) {
            path.add(root);
            return true;
        }
        boolean isOnRight = constructPath(path, root.right, sn);
        if (isOnRight) {
            path.add(root);
            return true;
        }
        return false;
    }
}