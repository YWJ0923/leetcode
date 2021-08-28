/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        head.next = null;
        ListNode r = head;
        ListNode p;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                p = l1.next;
                l1.next = r.next;
                r.next = l1;
                r = l1;
                l1 = p;
            }
            else {
                p = l2.next;
                l2.next = r.next;
                r.next = l2;
                r = l2;
                l2 = p;
            }
        }
        if (l1 != null) {
            r.next = l1;
        }
        else {
            r.next = l2;
        }
        return head.next;
    }
}