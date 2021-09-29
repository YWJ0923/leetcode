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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return myBuildTree(preorder, inorder, 0, 0, inorder.length - 1);
    }

    public TreeNode myBuildTree(int[] preorder, int[] inorder, int index, int left, int right) {
        if (left > right) {
            return null;
        }
        TreeNode node = new TreeNode(preorder[index]);
        int mid;
        for (mid = left; mid <= right && inorder[mid] != preorder[index]; mid++){}
        node.left = myBuildTree(preorder, inorder, index + 1, left, mid - 1);
        node.right = myBuildTree(preorder, inorder, index + 1 + mid - left, mid + 1, right);
        return node;
    }
}
