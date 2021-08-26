class Solution {
    public ListNode deleteNode(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        if (head.val == val) {
            return head.next;
        }
        ListNode p = head, q = head.next;
        while (q != null) {
            if (q.val == val) {
                p.next = q.next;
                break;
            }
            q = q.next;
            p = p.next;
        }
        return head;
    }
}