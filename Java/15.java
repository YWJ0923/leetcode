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
                    ans.add(Arrays.asList(nums[first], nums[second], nums[third]));
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

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums.length < 3) {
            return ans;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int k = nums.length - 1;
            for (int j = i + 1; j < k; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                while (j < k && nums[i] + nums[j] + nums[k] > 0) {
                    k--;
                }
                if (j == k) {
                    break;
                }
                if (nums[i] + nums[j] + nums[k] == 0) {
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(nums[i]);
                    tmp.add(nums[j]);
                    tmp.add(nums[k]);
                    ans.add(tmp);
                }
            }
        }
        return ans;
    }
}
