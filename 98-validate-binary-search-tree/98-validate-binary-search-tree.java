class Solution {
    public boolean isValidBST(TreeNode root) {
        ArrayDeque<TreeNode> Stack = new ArrayDeque<>();
        TreeNode curr = root;
        Integer prev = null;
        while (!Stack.isEmpty() || curr != null) {
            if (curr != null) {
                Stack.push(curr);
                curr = curr.left;
            } else {
                curr = Stack.pop();
                // System.out.print(curr.val + " ");
                if (prev != null && curr.val <= prev) {
                    return false;
                }
                prev = curr.val;
                curr = curr.right;
            }
        }
        return true;
    }
}