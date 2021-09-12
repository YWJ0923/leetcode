//O(n)
class Solution {
    public int missingNumber(int[] nums) {
        int len = nums.length;
        int i;
        for (i = 0; i < len && nums[i] == i; i++) {}
        return i;
    }
}

//O(logn)
class Solution {
    public int missingNumber(int[] nums) {
        int len = nums.length;
        int left = 0, right = len - 1, mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] > mid) {
                right = mid - 1;
            } else if (nums[mid] == mid) {
                left = mid + 1;
            }
        }
        return left;
    }
}