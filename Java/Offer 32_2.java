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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> ans = new ArrayList<>();
        TreeNode[] queue = new TreeNode[10000];
        int front = 0, rear = 0;
        int nextLevel = 0, toBePrinted = 1;
        queue[rear++] = root;
        List<Integer> level = new ArrayList<Integer>();
        while (front < rear) {
            TreeNode p = queue[front++];
            if (p.left != null) {
                queue[rear++] = p.left;
                nextLevel++;
            }
            if (p.right != null) {
                queue[rear++] = p.right;
                nextLevel++;
            }
            level.add(p.val);
            toBePrinted--;
            if (toBePrinted == 0) {
                toBePrinted = nextLevel;
                nextLevel = 0;
                ans.add(level);
                level = new ArrayList<Integer>();
            }
        }
        return ans;
    }
}