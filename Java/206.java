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
    public ListNode reverseList(ListNode head) {
        ListNode vHead = new ListNode();
        vHead.next = null;
        ListNode p = head, q;
        while (p != null) {
            q = p.next;
            p.next = vHead.next;
            vHead.next = p;
            p = q;
        }
        return vHead.next;
    }
}