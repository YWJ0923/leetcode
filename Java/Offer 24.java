/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode newHead = new ListNode(0);
        newHead.next = null;
        ListNode p = head, q;
        while (p != null) {
            q = p.next;
            p.next = newHead.next;
            newHead.next = p;
            p = q;
        }
        return newHead.next;
    }
}