class Solution {
    public int findDuplicate(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] != i + 1) {
                if (nums[i] == nums[nums[i] - 1]) {
                    return nums[i];
                }
                int tmp = nums[i];
                nums[i] = nums[tmp - 1];
                nums[tmp - 1] = tmp;
            } else {
                i++;
            }
        }
        return 0;
    }
}