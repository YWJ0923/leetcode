class Solution {
    public boolean exist(char[][] board, String word) {
        int row = board.length;
        int colomn = board[0].length;
        int len = word.length();
        var used = new boolean[row][colomn];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < colomn; j++) {
                used[i][j] = false;
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < colomn; j++) {
                boolean result = myExist(board, word, used, row, colomn, len, i, j, 0);
                if (result) {
                    return true;
                }
            }
        }
        return false;
    }
    public boolean myExist(char[][] board, String word, boolean[][] used, int row, int colomn, int len, int r, int c, int k) {
        boolean result = false;
        if (r >= 0 && r < row && c >= 0 && c < colomn && k < len) {
            if (board[r][c] == word.charAt(k) && used[r][c] == false) {
                used[r][c] = true;
                if (k == len - 1) {
                    return true;
                }
                result = myExist(board, word, used, row, colomn, len, r + 1, c, k + 1) || myExist(board, word, used, row, colomn, len, r - 1, c, k + 1) || myExist(board, word, used, row, colomn, len, r, c + 1, k + 1) || myExist(board, word, used, row, colomn, len, r, c - 1, k + 1);
                used[r][c] = false;
            }
        }
        return result;
    }
}