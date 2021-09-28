class Solution {
    public boolean exist(char[][] board, String word) {
        int r = board.length;
        int c = board[0].length;
        boolean[][] visited = new boolean[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (myExist(board, word, visited, 0, r, c, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean myExist(char[][] board, String word, boolean[][] visited, int index, int r, int c, int x, int y) {
        if (index == word.length()) {
            return true;
        }
        if (x >= 0 && x < r && y >= 0 && y < c && !visited[x][y] && board[x][y] == word.charAt(index)) {
            visited[x][y] = true;
            if (myExist(board, word, visited, index + 1, r, c, x + 1, y) || myExist(board, word, visited, index + 1, r, c, x - 1, y) || myExist(board, word, visited, index + 1, r, c, x, y + 1) || myExist(board, word, visited, index + 1, r, c, x, y - 1)) {
                return true;
            }
            visited[x][y] = false;
        }
        return false;
    }
}