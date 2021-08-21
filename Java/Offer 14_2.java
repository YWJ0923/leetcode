class Solution {
    public int cuttingRope(int n) {
        if (n <= 3) {
            return n - 1;
        }
        long result = 1;
        while (n >= 5) {
            result = result * 3 % 1000000007;
            n -= 3;
        }
        if (n > 0) {
            result = result * n % 1000000007;
        }
        return (int)result;
    }
}