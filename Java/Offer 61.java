class Solution {
    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int i = 0;
        while (nums[i] == 0) {
            i++;
        }
        int count = i;
        if (count >= 4) {
            return true;
        }
        int low = nums[i];
        int wrong = 0;
        for (i = i + 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                return false;
            }
            if (nums[i] != low + i - count) {
                wrong += nums[i] - nums[i - 1] - 1;
            }
        }
        return wrong <= count;
    }
}