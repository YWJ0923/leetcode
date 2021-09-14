class Solution {
    public int[][] findContinuousSequence(int target) {
        List<int[]> list = new ArrayList<int[]>();
        int left = 1, right = 2;
        int sum;
        while (right <= target / 2 + 1) {
            sum = (left + right) * (right - left + 1) / 2;
            if (sum == target) {
                int[] tmp = new int[right - left + 1];
                for (int i = 0; i < right - left + 1; i++) {
                    tmp[i] = left + i;
                }
                list.add(tmp);
                right++;
                left++;
            } else if (sum > target) {
                left++;
            } else {
                right++;
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}