class Solution {
    public int reverse(int x) {
        int res = 0;
        while (x != 0) {
            int tmp = x % 10;
            if (res >= 0 && res < Integer.MAX_VALUE / 10 || res == Integer.MAX_VALUE / 10 && tmp <= Integer.MAX_VALUE % 10) {
                res *= 10;
            } else if (res < 0 && res > Integer.MIN_VALUE / 10 || res == Integer.MIN_VALUE / 10 && tmp >= Integer.MIN_VALUE % 10) {
                res *= 10;
            } else {
                return 0;
            }
            res += tmp;
            x /= 10;
        }
        return res;
    }
}