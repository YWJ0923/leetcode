class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int count = 1;
        for (int i = 0; i < n && res[i][i] == 0; i++) {
            for (int j = 0; j < n - i * 2; j++) {
                res[i][i + j] = count;
                count++;
            }
            count--;
            for (int j = 0; j < n - i * 2; j++) {
                res[i + j][n - i - 1] = count;
                count++;
            }
            count--;
            for (int j = 0; j < n - i * 2; j++) {
                res[n - i - 1][n - 1 - i - j] = count;
                count++;
            }
            count--;
            for (int j = 0; j < n - i * 2 - 1; j++) {
                res[n - i - 1 - j][i] = count;
                count++;
            }
        }
        return res;
    }
}