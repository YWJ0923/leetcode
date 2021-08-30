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
    public int[] levelOrder(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        ArrayList<Integer> ans = new ArrayList<Integer>();
        TreeNode[] queue = new TreeNode[10000];
        int front = 0, rear = 0;
        queue[rear++] = root;
        while (front < rear) {
            TreeNode p = queue[front++];
            if (p != null) {
                ans.add(p.val);
                queue[rear++] = p.left;
                queue[rear++] = p.right;
            }
        }
        int n = ans.size();
        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            answer[i] = ans.get(i);
        }
        return answer;
    }
}