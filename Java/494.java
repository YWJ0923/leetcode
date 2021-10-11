class Solution {
    int res = 0;
    public int findTargetSumWays(int[] nums, int target) {
        myFind(nums, target, 0);
        return res;
    }

    public void myFind(int[] nums, int target, int index) {
        if (index == nums.length) {
            if (target == 0) {
                res++;
            }
        } else {
            myFind(nums, target - nums[index], index + 1);
            myFind(nums, target + nums[index], index + 1);
        }
    }
}
