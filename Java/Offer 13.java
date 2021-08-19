class Solution {
    private int[][] used;
    public int movingCount(int m, int n, int k) {
        used = new int[m][n];
        return myMovingCount(m, n, k, 0, 0);
    }
    public int myMovingCount(int m, int n, int k, int x, int y) {
        if (x >= 0 && x < m && y >= 0 && y < n) {
            int sum = digitSum(x, y);
            if (sum <= k && used[x][y] == 0) {
                used[x][y] = 1;
                return myMovingCount(m, n, k, x + 1, y) + myMovingCount(m, n, k, x - 1, y) + myMovingCount(m, n, k, x, y + 1) + myMovingCount(m, n, k, x, y - 1) + 1;
            }
        }
        return 0;
    }
    public int digitSum(int x, int y) {
        int sum = 0;
        while (x > 0 || y > 0) {
            sum += x % 10 + y % 10;
            x /= 10;
            y /= 10;
        }
        return sum;
    }
}