class Solution {
    public int search(int[] nums, int target) {
        int index = Arrays.binarySearch(nums, target);
        int count = 0;
        for (int i = index; i >= 0 && i < nums.length; i++) {
            if (nums[i] == target) {
                count++;
            }
        }
        for (int i = index - 1; i >= 0 && i < nums.length; i--) {
            if (nums[i] == target) {
                count++;
            }
        }
        return count;
    }
}

class Solution {
    public int search(int[] nums, int target) {
        int count = 0;
        int index = Arrays.binarySearch(nums, target);
        for (int i = index; i >= 0 && i < nums.length && nums[i] == target; i++) {
            count++;
        }
        for (int i = index - 1; i >= 0 && i < nums.length && nums[i] == target; i--) {
            count++;
        }
        return count;
    }
}