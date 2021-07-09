/*
我这个相当于是DFS的暴力算法，只是我省去了根节点不同时候的比较
用字符串匹配需要在节点的孩子为空时，加上空的标记，否则是错的
*/
bool isIdentical(struct TreeNode *p, struct TreeNode *t)
{
    if (t == NULL && p == NULL)
        return true;
    if (p != NULL && t != NULL && p->val == t->val)
        return isIdentical(p->left, t->left) && isIdentical(p->right, t->right);
    return false;
}

bool isSubtree(struct TreeNode* s, struct TreeNode* t){
    struct TreeNode *stack[100000];
    int top = -1;
    struct TreeNode *p = s;
    while (p != NULL || top != -1) {
        if (p != NULL) {
            if (p->val == t->val) {
                if (isIdentical(p, t))
                    return true;
            }
            stack[++top] = p;
            p = p->left;
        }
        else {
            p = stack[top--];
            p = p->right;
        }
    }
    return false;
}