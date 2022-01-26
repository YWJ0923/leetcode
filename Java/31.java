class Solution {
    public void nextPermutation(int[] nums) {
        if (nums.length == 1) {
            return;
        }
        int n = nums.length;
        for (int i = n - 2; i >= 0; i--) {
            for (int j = n - 1; j > i; j--) {
                if (nums[i] < nums[j]) {
                    int tmp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = tmp;
                    Arrays.sort(nums, i + 1, n);
                    return;
                }
            }
        }
        Arrays.sort(nums);
    }
}

class Solution {
    public void nextPermutation(int[] nums) {
        if (nums.length == 1) {
            return;
        }
        int i, j;
        for (i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                break;
            }
        }
        if (i == -1) {
            reverse(nums, i + 1);
            return;
        }
        for (j = nums.length - 1; j > i && nums[j] <= nums[i];j--) {}
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
        reverse(nums, i + 1);
    }

    public void reverse(int[] nums, int start) {
        for (int i = 0; i < (nums.length - start) / 2; i++) {
            int tmp = nums[start + i];
            nums[start + i] = nums[nums.length - i - 1];
            nums[nums.length - i - 1] = tmp;
        }
    }
}

class Solution {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2, mark1 = 0, mark2 = 0;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (nums[j] <= nums[i]) {
                j--;
            }
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
            Arrays.sort(nums, i + 1, nums.length);
        } else {
            Arrays.sort(nums);
        }
    }
}