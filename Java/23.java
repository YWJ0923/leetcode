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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        ListNode head = new ListNode(0);
        head.next = lists[0];
        for (int i = 1; i < lists.length; i++) {
            merge(head, head.next, lists[i]);
        }
        return head.next;
    }

    public void merge(ListNode head, ListNode l1, ListNode l2) {
        ListNode r = head;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                r.next = l1;
                r = l1;
                l1 = l1.next;
            } else {
                r.next = l2;
                r = l2;
                l2 = l2.next;
            }
        }
        if (l1 != null) {
            r.next = l1;
        }
        if (l2 != null) {
            r.next = l2;
        }
    }
}