//这种在leetcode上通不过，原因应该是使用了全局变量，代码应该是没问题的

#include <limits.h>

int preval = INT_MIN;

bool isValidBST(struct TreeNode* root){
    bool sign1, sign2;
    if (root == NULL)
        return true;
    else {
        sign1 = isValidBST(root->left);
        if (sign1 == false || preval >= root->val)
            return false;
        preval = root->val;
        sign2 = isValidBST(root->right);
        return sign2;        
    }
}

//不用全局变量的
#include <limits.h>

bool JudgeBST(struct TreeNode *root, long long lower, long long upper) {
    if (root == NULL)
        return true;
    if (root->val <= lower || root->val >= upper)
        return false;
    else
        return JudgeBST(root->left, lower, root->val) && JudgeBST(root->right, root->val, upper);
}

bool isValidBST(struct TreeNode *root) {
    return JudgeBST(root, LLONG_MIN, LLONG_MAX);
}

//非递归中序遍历
#include <limits.h>

bool isValidBST(struct TreeNode *root) {
    struct TreeNode *stack[100000];
    int top = -1;
    long long preval = LLONG_MIN;
    while (top != -1 || root != NULL) {
        if (root != NULL) {
            stack[++top] = root;
            root = root->left;
        }
        else {
            root = stack[top--];
            if (root->val <= preval)
                return false;
            preval = root->val;
            root = root->right;
        }
    }
    return true;
}

