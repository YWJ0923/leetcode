//两次二分查找或者 把矩阵行串起来看成一个数组，做一次二分查找
//我这C++标准库还不太会用

#include <vector>
#include <iostream>

using namespace std;

class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        int row = matrix.size(), column = matrix[0].size();
        if (target < matrix[0][0] || target > matrix[row - 1][column - 1]) {
            return false;
        }
        int low = 0, high = row - 1, mid;
        while(low <= high) {
            mid = (low + high) / 2;
            if (matrix[mid][0] > target) {
                high = mid - 1;
            }
            else if (matrix[mid][0] < target) {
                low = mid + 1;
            }
            else 
                return true;
        }
        int k = high;
        low = 0;
        high = column - 1;
        while (low <= high) {
            mid = (low + high) / 2;
            if (matrix[k][mid] > target) {
                high = mid - 1;
            }
            else if (matrix[k][mid] < target) {
                low = mid + 1;
            }
            else 
                return true;
        }
        return false;
    }
};

int main()
{
    vector<vector<int>> matrix = {{1}};
    Solution s;
    cout << s.searchMatrix(matrix, 0) << endl;
    system("pause");
    return 0;
}