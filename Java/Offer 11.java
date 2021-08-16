//特别处理 ｛1，0，1，1，1｝这种情况

class Solution {
    public int minArray(int[] numbers) {
        int min = numbers[0];
        int n = numbers.length;
        int left = 1, right = n - 1, mid;
        while (left <= right) {
            mid = (left + right) / 2;
            if (numbers[mid] == numbers[left] && numbers[mid] == numbers[right]) {
                return minInorder(numbers, min, left, right);
            }
            if (numbers[mid] < min) {
                min = numbers[mid];
            }
            else if (numbers[mid] > numbers[right]) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return min;
    }
    public int minInorder(int[] numbers, int min, int left, int right) {
        int ans = min;
        for (int i = left; i <= right; i++) {
            if (numbers[i] < ans) {
                ans = numbers[i];
            }
        }
        return ans;
    }
}