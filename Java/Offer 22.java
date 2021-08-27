/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode p = head;
        ListNode q = head;
        int i = 0;
        for (i = 0; q != null && i < k; i++) {
            q = q.next;
        }
        if (i < k) {
            return null;
        }
        while (q != null) {
            p = p.next;
            q = q.next;
        }
        return p;
    }
}