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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode pre = null, res = l1;
        while (l1 != null && l2 != null) {
            int tmp = l1.val + l2.val + carry;
            carry = tmp / 10;
            l1.val = tmp % 10;
            pre = l1;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            int tmp = l1.val + carry;
            carry = tmp / 10;
            l1.val = tmp % 10;
            pre = l1;
            l1 = l1.next;
        }
        if (l2 != null) {
            pre.next = l2;
            while (l2 != null) {
                int tmp = l2.val + carry;
                carry = tmp / 10;
                l2.val = tmp % 10;
                pre = l2;
                l2 = l2.next;
            }
        }
        if (carry == 1) {
            ListNode node = new ListNode(1);
            pre.next = node;
        }
        return res;
    }
}