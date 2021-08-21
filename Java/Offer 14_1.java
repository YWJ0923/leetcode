class Solution {
    private int[] result;
    public int cuttingRope(int n) {
        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        var result = new int[n + 1];
        result[1] = 1;
        result[2] = 2;
        for (int i = 3; i <= n; i++) {
            result[i] = i;
            for (int j = 1; j <= i / 2; j++) {
                int tmp = result[i - j] * result[j];
                if (result[i] < tmp) {
                    result[i] = tmp;
                }
            }
        }
        return result[n];
    }
}