class Solution {
    private int max = 0;
    public int maxValue(int[][] grid) {
        int row = grid.length;
        int colomn = grid[0].length;
        int[][] tempMax = new int[row][colomn];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < colomn; j++) {
                int up = i > 0 ? tempMax[i - 1][j] : 0;
                int left = j > 0 ? tempMax[i][j - 1] : 0;
                tempMax[i][j] = Integer.max(up, left) + grid[i][j];
            }
        }
        return tempMax[row - 1][colomn - 1];
    }   
}
