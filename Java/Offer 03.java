//O(n) O(n)
class Solution {
    public int findRepeatNumber(int[] nums) {
        int n = nums.length;
        var count = new int[n];
        for (int i = 0; i < n; i++) {
            if (count[nums[i]] != 0) {
                return nums[i];
            }
            count[nums[i]]++;
        }
        return 0;
    }
}