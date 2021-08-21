class Solution {
    public int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int prepre = 0, pre = 1, sum = 0;
        for (int i = 2; i <= n; i++) {
            sum = (prepre + pre) % 1000000007;
            prepre = pre;
            pre = sum;
        }
        return sum;
    }
}
