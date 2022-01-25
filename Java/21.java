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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode head, p, q;
        if (l1.val <= l2.val) {
            head = l1;
            p = l1.next;
            q = l2;
        } else {
            head = l2;
            p = l1;
            q = l2.next;
        }
        head.next = null;
        ListNode r = head, k;
        while (p != null && q != null) {
            if (p.val <= q.val) {
                k = p.next;
                r.next = p;
                r = p;
                p = k;
            } else {
                k = q.next;
                r.next = q;
                r = q;
                q = k;
            }
        }
        if (p != null) {
            r.next = p;
        }
        if (q != null) {
            r.next = q;
        }
        return head;
    }
}

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(), r = head;
        ListNode p = list1, q = list2;
        while (p != null && q != null) {
            if (p.val <= q.val) {
                ListNode tmp = p.next;
                r.next = p;
                r = p;
                p = tmp;
            } else {
                ListNode tmp = q.next;
                r.next = q;
                r = q;
                q = tmp;
            }
        }
        if (p != null) {
            r.next = p;
        } else {
            r.next = q;
        }
        return head.next;
    }
}