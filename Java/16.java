class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = 0, n = nums.length;
        int first, second, third, diff = Integer.MAX_VALUE;
        for (first = 0; first < n - 2; first++) {
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            second = first + 1;
            third = n - 1;
            while (second < third) {
                int sum = nums[first] + nums[second] + nums[third];
                int tmpDiff = Math.abs(target - sum);
                if (tmpDiff == 0) {
                    return sum;
                }
                if (tmpDiff < diff) {
                    ans = sum;
                    diff = tmpDiff;
                }
                if (sum > target) {
                    third--;
                }
                else {
                    second++;
                }
            }
        }
        return ans;
    }
}
