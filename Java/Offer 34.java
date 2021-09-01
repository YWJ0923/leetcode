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
    private List<List<Integer>> ans = new ArrayList<>();
    private List<Integer> arr = new ArrayList<Integer>();
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        myPathSum(root, target);
        return ans;
    }

    public void myPathSum(TreeNode root, int target) {
        if (root == null) {
            return;
        }
        arr.add(root.val);
        if (root.val == target && root.left == null && root.right == null) {
            List<Integer> ansList = new ArrayList<Integer>(arr);
            ans.add(ansList);
        }
        else {
            if (root.left != null) {
                myPathSum(root.left, target - root.val);
            }
            if (root.right != null) {
                myPathSum(root.right, target - root.val);
            }
        }
        if (arr.size() > 0) {
            arr.remove(arr.size() - 1);
        }
    }
}