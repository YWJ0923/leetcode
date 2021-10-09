import java.util.AbstractMap.SimpleEntry;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        List<SimpleEntry<Integer, Integer>> list = new ArrayList<SimpleEntry<Integer, Integer>>();
        Arrays.sort(nums);
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                count++;
            } else {
                list.add(new SimpleEntry<Integer, Integer>(nums[i - 1], count));
                count = 1;
            }
        }
        list.add(new SimpleEntry<Integer, Integer>(nums[nums.length - 1], count));
        Collections.sort(list, new Comparator<SimpleEntry<Integer, Integer>>() {
            public int compare(SimpleEntry<Integer, Integer> e1, SimpleEntry<Integer, Integer> e2) {
                return e2.getValue() - e1.getValue();
            }
        });
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = list.get(i).getKey();
        }
        return res;
    }
}
