class Solution {
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    List<Integer> tmp = new ArrayList<Integer>();
    public List<List<Integer>> permute(int[] nums) {
        boolean[] visit = new boolean[nums.length];
        myPermute(nums, 0, visit);
        return res;
    }

    public void myPermute(int[] nums, int index, boolean[] visit) {
        if (nums.length == index) {
            res.add(new ArrayList<Integer>(tmp));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (!visit[i]) {
                    tmp.add(nums[i]);
                    visit[i] = true;
                    myPermute(nums, index + 1, visit);
                    tmp.remove(tmp.size() - 1);
                    visit[i] = false;
                }
            }
        }
    }
}