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
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode vHead = new ListNode();
        vHead.next = head;
        ListNode curPre = head, cur = head.next, curNext, p, pre, lastSorted = head;
        while (cur != null) {
            if (curPre.val <= cur.val) {
                curPre = curPre.next;
            }
            else {
                curNext = cur.next;
                p = vHead.next;
                pre = vHead;
                while (p.val <= cur.val && p != cur) {
                    pre = p;
                    p = p.next;
                }
                if (p != cur) {
                    curPre.next = curNext;
                    cur.next = p;
                    pre.next = cur;
                } else {
                    curPre = cur;
                }
            }
            cur = curPre.next;
        }
        return vHead.next;
    }
}
