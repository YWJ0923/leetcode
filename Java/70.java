class Solution {
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int prepre = 1, pre = 2, cur = 0;
        for (int i = 3; i <= n; i++) {
            cur = prepre + pre;
            prepre = pre;
            pre = cur;
        }
        return cur;
    }
}