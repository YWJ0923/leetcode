class Solution {
    public int[] searchRange(int[] nums, int target) {
        int index = Arrays.binarySearch(nums, target);
        if (index < 0) {
            return new int[]{-1, -1};
        }
        int low, high;
        for (low = index; low >= 0 && nums[low] == target; low--){}
        for (high = index; high < nums.length && nums[high] == target; high++){}
        return new int[]{low + 1, high - 1};
    }
}