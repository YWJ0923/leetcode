/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p = headA, q = headB;
        int len1 = 0, len2 = 0;
        while (p != null) {
            p = p.next;
            len1++;
        }
        while (q != null) {
            q = q.next;
            len2++;
        }
        if (len1 >= len2) {
            p = headA;
            q = headB;
        } else {
            p = headB;
            q = headA;
        }
        for (int i = 0; i < Math.abs(len1 - len2); i++) {
            p = p.next;
        }
        while (p != null && q != null && p != q) {
            p = p.next;
            q = q.next;
        }
        return p;
    }
}
