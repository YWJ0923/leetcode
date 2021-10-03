class Solution {
    public int maxProduct(int[] nums) {
        int res = nums[0];
        int max = nums[0], min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int mx = max, mn = min;
            max = Math.max(Math.max(mx * nums[i], nums[i]), mn * nums[i]);
            min = Math.min(Math.min(mn * nums[i], nums[i]), mx * nums[i]);
            res = Math.max(max, res);
        }
        return res;
    }
}
