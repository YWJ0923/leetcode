/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode p = head, q, pre = null;
        int len = 0;
        while (p != null) {
            len++;
            p = p.next;
        }
        k = k % len;
        if (k > 0) {
            p = head;
            q = head;
            while (k-- > 0) {
                q = q.next;
            }
            while (q.next != null) {
                pre = p;
                p = p.next;
                q = q.next;
            }
            q.next = head;
            head = p.next;
            p.next = null;
        }
        return head;
    }
}
