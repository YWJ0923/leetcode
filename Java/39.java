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

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        backTrace(ans, tmp, 0, target, candidates, 0);
        return ans;
    }

    public void backTrace(List<List<Integer>> ans, List<Integer> tmp, int sum, int target, int[] candidates, int index) {
        if (sum == target) {
            ans.add(new ArrayList(tmp));
            return;
        }
        if (sum > target) {
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            tmp.add(candidates[i]);
            backTrace(ans, tmp, sum + candidates[i], target, candidates, i);
            tmp.remove(tmp.size() - 1);
        }
    }
}
