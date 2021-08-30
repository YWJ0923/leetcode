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
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return myIsSymmetric(root.left, root.right);
    }

    public boolean myIsSymmetric(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 != null && node2 != null) {
            if (node1.val == node2.val) {
                return myIsSymmetric(node1.left, node2.right) && myIsSymmetric(node1.right, node2.left);
            }
        }
        return false;
    }
}
