class Solution {
    public int[] exchange(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return nums;
        }
        int n = nums[0];
        int left = 0, right = len - 1;
        while (left < right) {
            while (left < right && (nums[right] & 1) == 0) {
                right--;
            }
            nums[left] = nums[right];
            while (left < right && (nums[left] & 1) == 1) {
                left++;
            }
            nums[right] = nums[left];
        }
        nums[left] = n;
        return nums;
    }
}