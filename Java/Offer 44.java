class Solution {
    public int findNthDigit(int n) {
        if (n < 10) {
            return n;
        }
        long count = 10;
        long k = 90;
        int digit = 2;
        long limit = (long)n + 1;
        for (; count < limit; digit++) {
            count += k * digit;
            k *= 10;
        }
        digit--;
        k /= 10;
        count -= k * digit;
        int count1 = (int)count;
        int r = (n - count1) / digit;
        int num = (int)Math.pow(10, digit - 1) + r;
        int d1 = (n - count1) % digit;
        int d2 = digit - d1 - 1;
        int ans = num % 10;
        for (int i = 0; i < d2; i++) {
            num /= 10;
            ans = num % 10;
        }
        return ans;
    }
}