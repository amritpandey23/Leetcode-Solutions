/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int->val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() :->val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) :->val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) :->val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    bool isSubtree(TreeNode* root, TreeNode* subRoot) {
        if (!root && !subRoot) {
            return true;
        }
        if (!root || !subRoot) {
            return false;
        }
        bool isSameTree = false;
        if (root->val == subRoot->val) {
            isSameTree = isSame(root->left, subRoot->left) && isSame(root->right, subRoot->right);
        }
        return isSameTree || isSubtree(root->left, subRoot) || isSubtree(root->right, subRoot);
    }
    
private:
    bool isSame(const TreeNode* root1, const TreeNode* root2) {
        if (!root1 && !root2) {
            return true;
        }
        if (!root1 || !root2) {
            return false;
        }
        if (root1->val != root2->val) {
            return false;
        }
        return isSame(root1->left, root2->left) && isSame(root1->right, root2->right);
    }
};