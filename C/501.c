//BST的中序遍历是个升序序列，利用这个找众数

#include <limits.h>

int* findMode(struct TreeNode* root, int* returnSize){
    int *ans = (int *)malloc(sizeof(int) * 10000);
    *returnSize = 0;
    if (root == NULL) 
        return ans;
    int maxTimes = -1, preVal = INT_MAX, preTimes = 1; 
    struct TreeNode **stack = (struct TreeNode **)malloc(sizeof(struct TreeNode *) * 100000);
    struct TreeNode *p = root;
    int top = -1, arrSize = 0;
    while (p != NULL || top != -1) {
        if (p != NULL) {
            stack[++top] = p;
            p = p->left;
        }
        else {
            p = stack[top--];
            if (p->val == preVal) 
                preTimes++;
            else 
                preTimes = 1;
            if (preTimes > maxTimes) {
                ans[0] = p->val;
                arrSize = 0;
                maxTimes = preTimes;
            }
            else if (preTimes == maxTimes)
                ans[++arrSize] = p->val;
            preVal = p->val;
            p = p->right;
        }
    } 
    free(stack);
    *returnSize = arrSize + 1;
    return ans;
}