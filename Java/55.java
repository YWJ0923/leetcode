class Solution {
    public boolean canJump(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        int far = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (i > far) {
                return false;
            }
            far = Math.max(far, i + nums[i]);
            if (far >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }
}

class Solution {
    public boolean canJump(int[] nums) {
        int far = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (i <= far) {
                far = Math.max(far, i + nums[i]);
                if (far >= n - 1) {
                    return true;
                }
            }
        }
        return false;
    }
}