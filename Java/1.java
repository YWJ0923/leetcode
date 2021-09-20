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

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (!hashMap.containsKey(target - nums[i])) {
                hashMap.put(nums[i], i);
            } else {
                return new int[]{i, hashMap.get(target - nums[i])};
            }
        }
        return new int[0];
    }
}