class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        int n = nums.length;
        int first, second, third;
        for (first = 0; first < n - 2 && nums[first] <= 0; first++) {
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            second = first + 1;
            third = n - 1;
            while (second < third) {
                if (nums[first] + nums[second] + nums[third] == 0) {
                    while (second < third - 1 && nums[second] == nums[second + 1]) {
                        second++;
                    }
                    while (second + 1 < third && nums[third] == nums[third - 1]) {
                        third--;
                    }
                    List<Integer> tmp = new ArrayList<Integer>();
                    tmp.add(nums[first]);
                    tmp.add(nums[second]);
                    tmp.add(nums[third]);
                    ans.add(tmp);
                    second++;
                    third--;
                }
                else if (nums[first] + nums[second] + nums[third] < 0) {
                    second++;
                }
                else {
                    third--;
                }
            }
            
        }
        return ans;
    }
}