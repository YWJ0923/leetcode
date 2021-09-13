/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private int res = 0;
    private int depth = 0;
    public int maxDepth(TreeNode root) {
        myMaxDepth(root);
        return res;
    }
    public void myMaxDepth(TreeNode root) {
        if (root != null) {
            depth++;
            res = Math.max(res, depth);
            myMaxDepth(root.left);
            myMaxDepth(root.right);
            depth--;
        }
    }
}

class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }
}