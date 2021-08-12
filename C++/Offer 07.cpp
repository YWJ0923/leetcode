class Solution {
private:
    unordered_map<int, int> m;
public:
    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
        int n = inorder.size();
        for (int i = 0; i < n; i++) {
            m[inorder[i]] = i;
        }
        return build(preorder, inorder, 0, 0, inorder.size() - 1);
        
    }
    TreeNode* build(vector<int>& preorder, vector<int>& inorder, int k, int beg, int end) {
        if (beg > end) {
            return NULL;
        }
        TreeNode *root = new TreeNode(preorder[k]);
        int index = m[preorder[k]];
        root->left = build(preorder, inorder, k + 1, beg, index - 1);
        root->right = build(preorder, inorder, k + index - beg + 1, index + 1, end);
        return root;
    }
};