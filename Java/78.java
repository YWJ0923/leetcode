class Solution {
    List<Integer> tmp = new ArrayList<Integer>();
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    public List<List<Integer>> subsets(int[] nums) {
        res.add(new ArrayList<Integer>());
        mySubsets(nums, 0);
        return res;
    }

    public void mySubsets(int[] nums, int index) {
        if (index != nums.length) {
            for (int i = index; i < nums.length; i++) {
                tmp.add(nums[i]);
                res.add(new ArrayList<Integer>(tmp));
                mySubsets(nums, i + 1);
                tmp.remove(tmp.size() - 1);
            }
        }
    }
}
