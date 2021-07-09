//暴力算法，对每个值为1的元素，找它为左上角的最大正方形

#define Min(a, b) ((a) < (b) ? (a) : (b))
int FindMax(char **matrix, int i, int j, int matrixSize, int *matrixColSize)
{
    int ans = 1;
    int currentMaxSize = Min(matrixSize - i, matrixColSize[i] - j);
    for (int k = 1; k < currentMaxSize; k++) {
        int flag = 1;
        if (matrix[i + k][j + k] == '0')
            break;
        for (int m = 0; m < k; m++) {
            if (matrix[i + k][j + m] == '0' || matrix[i + m][j + k] == '0') {
                flag = 0;
                break;
            }
        }
        if (flag == 1)
            ans = (k + 1) > ans ? (k + 1) : ans;
        else 
            break;
    }
    return ans;
}

int maximalSquare(char** matrix, int matrixSize, int* matrixColSize){
    int length = 0, tmp;
    for (int i = 0; i < matrixSize; i++) {
        for (int j = 0; j < matrixColSize[i]; j++) {
            if (matrix[i][j] == '1') {
                tmp = FindMax(matrix, i, j, matrixSize, matrixColSize);
                if (tmp > length)
                    length = tmp;
            }
        }
    }   
    return length * length;
}

//动态规划，关键是dp[i][j] = Min(Min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;  dp[i][j]是(i，j)作为右下角时的最大正方形
#define Min(a, b) ((a) < (b) ? (a) : (b))

int maximalSquare(char** matrix, int matrixSize, int* matrixColSize){
    int length = 0;
    int **dp;
    dp = (int **)malloc(sizeof(int *) * matrixSize);
    for (int i = 0; i < matrixSize; i++)
        dp[i] = (int *)malloc(sizeof(int) * matrixColSize[0]);
    for (int i = 0; i < matrixSize; i++) {
        for (int j = 0; j < matrixColSize[0]; j++)
            dp[i][j] = 0;
    }
    for (int i = 0; i < matrixSize; i++) {
        for (int j = 0; j < matrixColSize[i]; j++) {
            if (matrix[i][j] == '1') {
                if (i == 0 || j == 0)
                    dp[i][j] = 1;
                else 
                    dp[i][j] = Min(Min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                if (dp[i][j] > length)
                    length = dp[i][j];
            }
        }
    }
    return length * length;
}