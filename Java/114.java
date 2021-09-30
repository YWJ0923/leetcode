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
    ArrayList<TreeNode> tmp = new ArrayList<TreeNode>();
    public void flatten(TreeNode root) {
        myFlatten(root);
        for (int i = 0; i < tmp.size(); i++) {
            TreeNode node = tmp.get(i);
            node.left = null;
            if (i == tmp.size() - 1) {
                node.right = null;
            } else {
                node.right = tmp.get(i + 1);
            }
        }
    }

    public void myFlatten(TreeNode root) {
        if (root != null) {
            tmp.add(root);
            myFlatten(root.left);
            myFlatten(root.right);
        }
    }
}
