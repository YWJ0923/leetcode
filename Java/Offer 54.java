class Solution {
    private int ans;
    private int k;
    private boolean find;
    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        myKthLargest(root);
        return ans;
    }

    public void myKthLargest(TreeNode root) {
        if (!find && root != null) {
            myKthLargest(root.right);
            k--;
            if (k == 0) {
                ans = root.val;
                find = true;
            }
            myKthLargest(root.left);
        }
    }
}