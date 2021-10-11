class Solution {
    public int hammingDistance(int x, int y) {
        int res = 0;
        x = x ^ y;
        for (int i = 0; i < 32; i++) {
            if ((x & 1) == 1) {
                res++;
            }
            x >>= 1;
        }
        return res;
    }
}
