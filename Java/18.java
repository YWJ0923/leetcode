class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int first, second, third, fourth;
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        for (first = 0; first < n - 3; first++) {
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            for (second = first + 1; second < n - 2; second++) {
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                third = second + 1;
                fourth = n - 1;
                while (third < fourth) {
                    if (third > second + 1 && nums[third] == nums[third - 1]) {
                        third++;
                        continue;
                    }
                    if (fourth < n - 1 && nums[fourth] == nums[fourth + 1]) {
                        fourth--;
                        continue;
                    }
                    int sum = nums[first] + nums[second] + nums[third] + nums[fourth];
                    if (sum == target) {
                        List<Integer> tmp = new ArrayList<Integer>();
                        tmp.add(nums[first]);
                        tmp.add(nums[second]);
                        tmp.add(nums[third]);
                        tmp.add(nums[fourth]);
                        ans.add(tmp);
                        third++;
                        fourth--;
                    }
                    else if (sum < target) {
                        third++;
                    }
                    else {
                        fourth--;
                    }
                }
            }
        }
        return ans;
    }
}