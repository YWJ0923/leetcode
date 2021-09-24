class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            myRotate(matrix, i);
        }
    }

    public void myRotate(int[][] matrix, int begin) {
        int n = matrix.length;
        int len = n - 2 * begin;
        int[] tmp = new int[len];
        for (int i = 0; i < len; i++) {
            tmp[i] = matrix[begin][begin + i];
        }
        for (int i = 0; i < len - 1; i++) {
            matrix[begin][begin + len - 1 - i] = matrix[begin + i][begin];
            matrix[begin + i][begin] = matrix[begin + len - 1][begin + i];
            matrix[begin + len - 1][begin + i] = matrix[begin + len - 1 - i][begin + len - 1];
            matrix[begin + len - 1 - i][begin + len - 1] = tmp[len - i - 1];
        }
    }
}
