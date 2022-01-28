class Solution {
    public int maxSubArray(int[] nums) {
        int res = nums[0];
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum = Math.max(sum + nums[i], nums[i]);
            res = Math.max(res, sum);
        }
        return res;
    }
}

class Solution {
    public int maxSubArray(int[] nums) {
        int ans = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = Math.max(0, sum);
            sum += nums[i];
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}