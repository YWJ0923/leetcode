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
        int len1 = 0, len2 = 0;
        ListNode p, q;
        for (p = headA; p != null; p = p.next) {
            len1++;
        }
        for (p = headB; p != null; p = p.next) {
            len2++;
        }
        int diff;
        if (len1 > len2) {
            diff = len1 - len2;
            q = headA;
            p = headB;
        } else {
            diff = len2 - len1;
            q = headB;
            p = headA;
        }
        for (int i = 0; i < diff; i++) {
            q = q.next;
        }
        while (p != q) {
            p = p.next;
            q = q.next;
        }
        return p;
    }
}