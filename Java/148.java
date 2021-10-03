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
    public ListNode sortList(ListNode head) {
        ListNode[] tmp = new ListNode[50001];
        int count = 0;
        ListNode p = head;
        while (p != null) {
            tmp[count++] = p;
            p = p.next;
        }
        Arrays.sort(tmp, 0, count, new Comparator<ListNode>() {
            public int compare(ListNode p1, ListNode p2) {
                return p1.val - p2.val;
            }
        });
        ListNode vHead = new ListNode();
        p = vHead;
        for (int i = 0; i < count; i++) {
            p.next = tmp[i];
            p = tmp[i];
        }
        p.next = null;
        return vHead.next;
    }
}
