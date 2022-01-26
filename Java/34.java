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

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = 0, right = nums.length - 1, mid;
        int ans1 = -1, ans2 = -1;
        while (left <= right) {
            mid = (left + right) >> 1;
            if (nums[mid] == target) {
                ans1 = mid;
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        left = 0;
        right = nums.length - 1;
        while (left <= right) {
            mid = (left + right) >> 1;
            if (nums[mid] == target) {
                ans2 = mid;
                left = mid + 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return new int[]{ans1, ans2};
    }
}