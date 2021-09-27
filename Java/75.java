class Solution {
    public void sortColors(int[] nums) {
        int r = -1, w, b;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                if (i > r + 1) {
                    int tmp = nums[i];
                    nums[i] = nums[r + 1];
                    nums[r + 1] = tmp;
                }
                r++;
            }
        }
        w = r;
        for (int i = r + 1; i < nums.length; i++) {
            if (nums[i] == 1) {
                if (i > w + 1) {
                    int tmp = nums[i];
                    nums[i] = nums[w + 1];
                    nums[w + 1] = tmp;
                }
                w++;
            }
        }
    }
}