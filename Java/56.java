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

class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (i1, i2) -> i1[0] - i2[0]);
        List<int[]> merged = new ArrayList<int[]>();
        for (int i = 0; i < intervals.length; ++i) {
            int L = intervals[i][0], R = intervals[i][1];
            if (merged.size() == 0 || merged.get(merged.size() - 1)[1] < L) {
                merged.add(new int[]{L, R});
            } else {
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], R);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}