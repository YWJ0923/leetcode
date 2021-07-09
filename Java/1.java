class Solution {
    public int[] twoSum(int[] nums, int target) {
        var hashTable = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (hashTable.containsKey(target - nums[i])) {
                return (new int[] {i, hashTable.get(target - nums[i])});
            }
            hashTable.put(nums[i], i);
        }
        return new int[0];
    }
}