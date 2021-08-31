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
        TreeNode[] queue = new TreeNode[9000];
        int front = 0, rear = 0;
        queue[rear++] = root;
        int nextLevel = 0, toBePrinted = 1;
        boolean order = true;
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
                if (!order) {
                    Collections.reverse(level);
                }
                ans.add(level);
                level = new ArrayList<Integer>();
                order = !order;
            }
        }
        return ans;
    }
}