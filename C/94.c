

int* inorderTraversal(struct TreeNode* root, int* returnSize){
    int *a = (int *)malloc(sizeof(int) * 100000);
    memset(a, 0, sizeof(int) * 100000);
    *returnSize = 0;
    struct TreeNode **stack = (struct TreeNode **)malloc(sizeof(struct TreeNode *) * 100000);
    struct TreeNode *p = root;
    int top = -1;
    while (p != NULL || top != -1) {
        if (p != NULL) {
            stack[++top] = p;
            p = p->left;
        }
        else {
            p = stack[top--];
            a[(*returnSize)++] = p->val;
            p = p->right;
        }
    } 
    free(stack);
    return a;
}

