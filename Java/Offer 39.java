class Solution {
    public int majorityElement(int[] nums) {
        int count = 1;
        int num = nums[0];
        int len = nums.length;
        for (int i = 1; i < len; i++) {
            if (nums[i] != num) {
                count--;
            } else {
                count++;
            }
            if (count < 0) {
                num = nums[i];
                count = 1;
            }
        }
        return num;
    }
}