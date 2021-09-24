class Solution {
    private List<List<Integer>> res = new ArrayList<List<Integer>>();
    private List<Integer> tmp = new ArrayList<Integer>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        myCombinationSum(candidates, target, 0, 0);
        return res;
    }

    public void myCombinationSum(int[] candidates, int target, int sum, int index) {
        if (sum == target) {
            res.add(tmp);
            tmp = new ArrayList<Integer>(tmp);
            
        } else if (sum < target) {
            for (int i = index; i < candidates.length; i++) {
                sum += candidates[i];
                tmp.add(candidates[i]);
                myCombinationSum(candidates, target, sum, i);
                sum -= candidates[i];
                tmp.remove(tmp.size() - 1);
            }
        }
    }
}
