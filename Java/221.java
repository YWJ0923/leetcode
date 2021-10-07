//用暴力法的时间居然比动态规划短，我吐了

class Solution {
    public int maximalSquare(char[][] matrix) {
        int res = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int limit = Math.min(m - i, n - j);
                if (matrix[i][j] == '1' && limit * limit > res) {
                    res = Math.max(res, 1);
                    int length;
                    boolean flag = true;
                    for (length = 1; length < limit; length++) {
                        for (int x = 0; x < length; x++) {
                            if (matrix[i + length][j + x] == '0' || matrix[i + x][j + length] == '0') {
                                flag = false;
                                break;
                            }
                        }
                        flag = flag && matrix[i + length][j + length] == '1';
                        if (!flag) {
                            break;
                        } else {
                            res = Math.max(res, (length + 1) * (length + 1));
                        }
                    }
                }
            }
        }
        return res;
    }
}

class Solution {
    public int maximalSquare(char[][] matrix) {
        int res = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    if (i > 0 && j > 0) {
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i - 1][j - 1]), dp[i][j - 1]) + 1;
                    } else {
                        dp[i][j] = 1;
                    }
                    res = Math.max(res, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return res * res;
    }
    
}