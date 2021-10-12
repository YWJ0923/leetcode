/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int res = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        myDiameter(root);
        return res;
    }

    public int myDiameter(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = myDiameter(root.left);
        int right = myDiameter(root.right);
        res = Math.max(res, left + right);
        return Math.max(left, right) + 1;
    }
}