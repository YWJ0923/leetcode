class Solution {
    public int numWays(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int prepre = 1, pre = 1, sum = 0;
        for (int i = 2; i <= n; i++) {
            sum = (pre + prepre) % 1000000007;
            prepre = pre;
            pre = sum;
        }
        return sum;
    }
}