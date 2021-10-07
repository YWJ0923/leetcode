class Solution {
    public boolean isPalindrome(ListNode head) {
        Deque<Integer> stack = new ArrayDeque<Integer>();
        boolean even = true;
        ListNode p = head, q = head;
        while (q != null) {
            stack.push(p.val);
            p = p.next;
            q = q.next;
            if (q != null) {
                q = q.next;
            } else {
                even = false;
            }
        }
        if (!even) {
            stack.pop();
        }
        while (p != null) {
            if (stack.pop() != p.val) {
                return false;
            }
            p = p.next;
        }
        return true;
    }
}
