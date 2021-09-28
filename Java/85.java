class Solution {
    public int maximalRectangle(char[][] matrix) {
        int r = matrix.length;
        if (r == 0) {
            return 0;
        }
        int c = matrix[0].length;
        if (c == 0) {
            return 0;
        }
        int[][] left = new int[r][c];
        int res = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (j == 0) {
                    left[i][j] = matrix[i][j] == '1' ? 1 : 0;
                } else {
                    left[i][j] = matrix[i][j] == '1' ? left[i][j - 1] + 1 : 0;
                } 
                int width = left[i][j];
                for (int k = i; k >= 0 && matrix[k][j] == '1'; k--) {
                    width = Math.min(width, left[k][j]);
                    res = Math.max(res, width * (i - k + 1));
                }
                
            }
        }
        return res;
    }
}
