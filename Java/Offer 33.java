class Solution {
    public boolean verifyPostorder(int[] postorder) {
        int len = postorder.length;
        if (len <= 1) {
            return true;
        }
        return myVerifyPostorder(postorder, 0, len - 1);
    }

    public boolean myVerifyPostorder(int[] postorder, int beg, int end) {
        if (beg > end) {
            return false;
        }
        int root = postorder[end];
        int i = beg;
        for (; i < end; i++) {
            if (postorder[i] > root) {
                break;
            }
        }
        int j = i;
        for (; j < end; j++) {
            if (postorder[j] < root) {
                return false;
            }
        }
        boolean left = true;
        if (i > beg) {
            left = myVerifyPostorder(postorder, beg, i - 1);
        }
        boolean right = true;
        if (i < end - 1) {
            right = myVerifyPostorder(postorder, i, end - 1);
        }
        return left && right;
    }
}