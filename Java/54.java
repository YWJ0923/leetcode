class Solution {
    List<Integer> res = new ArrayList<Integer>();
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] visited = new int[m][n];
        for (int i = 0; i < Math.min(m, n); i++) {
            if (visited[i][i] == 0) {
                mySpiralOrder(matrix, visited, m, n, i);
            } else {
                break;
            }
        }
        return res;
    }

    public void mySpiralOrder(int[][] matrix, int[][] visited, int m, int n, int start) {
        for (int i = 0; i < n - 2 * start; i++) {
            if (visited[start][start + i] == 0) {
                res.add(matrix[start][start + i]);
                visited[start][start + i] = 1;
            }
        }
        for (int i = 0; i < m - 2 * start; i++) {
            if (visited[start + i][n - start - 1] == 0) {
                res.add(matrix[start + i][n - start - 1]);
                visited[start + i][n - start - 1] = 1;
            }
        }
        for (int i = 0; i < n - 2 * start; i++) {
            if (visited[m - start - 1][n - start - 1 - i] == 0) {
                res.add(matrix[m - start - 1][n - start - 1 - i]);
                visited[m - start - 1][n - start - 1 - i] = 1;
            }
        }
        for (int i = 0; i < m - 2 * start; i++) {
            if (visited[m - start - 1 - i][start] == 0) {
                res.add(matrix[m - start - 1 - i][start]);
                visited[m - start - 1 - i][start] = 1;
            }
        }
    }
}
