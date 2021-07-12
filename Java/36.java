class Solution {
    public boolean isValidSudoku(char[][] board) {
        var row = new int[9][10];
        var col = new int[9][10];
        var box = new int[9][10];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int n = Character.getNumericValue(board[i][j]);
                    if (row[i][n] > 0) {
                        return false;
                    }
                    else {
                        row[i][n]++;
                    }
                    if (col[j][n] > 0) {
                        return false;
                    }
                    else {
                        col[j][n]++;
                    }
                    int boxIndex = (i / 3) * 3 + j / 3;
                    if (box[boxIndex][n] > 0) {
                        return false;
                    }
                    else {
                        box[boxIndex][n]++;
                    }
                }
            }
        }
        return true;
    }
    
}

