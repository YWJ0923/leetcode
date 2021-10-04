class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    mark(grid, m, n, i, j);
                    res++;
                }
            }
        }
        return res;
    }

    public void mark(char[][] grid, int m, int n, int x, int y) {
        if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == '1') {
            grid[x][y] = '0';
            mark(grid, m, n, x + 1, y);
            mark(grid, m, n, x, y + 1);
            mark(grid, m, n, x - 1, y);
            mark(grid, m, n, x, y - 1);
        }
    }
}