/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    int maxDia = 0;
    
    int diameterOfBinaryTree(TreeNode* root) {
        findDiameter(root);
        return maxDia;
    }
    
    int findDiameter(TreeNode* root) {
        if (!root) {
            return 0;
        }
        int lh = findDiameter(root->left);
        int rh = findDiameter(root->right);
        maxDia = max(maxDia, lh + rh);
        return max(lh, rh) + 1;
    }
};