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

    public int pathSum(TreeNode root, int targetSum) {
        preOrder(root, targetSum);
        return res;
    }

    public void preOrder(TreeNode root, int targetSum) {
        if (root != null) {
            myPathSum(root, targetSum);
            preOrder(root.left, targetSum);
            preOrder(root.right, targetSum);
        }
    }

    public void myPathSum(TreeNode root, int targetSum) {
        if (root != null) {
            if (targetSum == root.val) {
                res++;
            }
            myPathSum(root.left, targetSum - root.val);
            myPathSum(root.right, targetSum - root.val);
        }
    }
}
