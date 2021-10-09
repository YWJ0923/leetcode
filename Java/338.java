class Solution {
    public int[] countBits(int n) {
        int[] res = new int[n + 1];
        int k = 1;
        res[0] = 0;
        for (int i = 1; i <= n; i++) {
            if ((i & (i - 1)) == 0) {
                k = i;
            }
            res[i] = res[i - k] + 1;
        }
        return res;
    }
}
