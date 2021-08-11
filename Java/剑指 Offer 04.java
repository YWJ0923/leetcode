//O(nlogm) O(1)
class Solution {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int row = matrix.length;
        if (row > 0) {
            int col = matrix[0].length;
            if (col == 0) {
                return false;
            }
            for (int i = 0; i < row; i++) {
                int left, right, mid;
                left = 0;
                right = col - 1;
                if (matrix[i][left] > target || matrix[i][right] < target) {
                    continue;
                }
                while (left <= right) {
                    mid = (left + right) >> 1;
                    if (matrix[i][mid] == target) {
                        return true;
                    }
                    else if (matrix[i][mid] > target) {
                        right = mid - 1;
                    }
                    else {
                        left = mid + 1;
                    }
                }
            }
        }
        return false;
    }
}