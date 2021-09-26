class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] arr1, int[] arr2) {
                return arr1[0] - arr2[0];
            }
        });
        ArrayList<int[]> tmp = new ArrayList<int[]>();
        int count = 0;
        int left = intervals[0][0], right = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= right && intervals[i][0] >= left || left >= intervals[i][0] && left <= intervals[i][1]) {
                left = Math.min(intervals[i][0], left);
                right = Math.max(intervals[i][1], right);
            } else {
                tmp.add(new int[]{left, right});
                left = intervals[i][0];
                right = intervals[i][1];
            }
        }
        tmp.add(new int[]{left, right});
        return tmp.toArray(new int[tmp.size()][2]);
    }
}