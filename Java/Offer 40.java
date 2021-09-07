class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        int len = arr.length;
        if (k == len) {
            return arr;
        }
        if (k == 0) {
            return new int[0];
        }
        int[] count = new int[10001];
        for (int i = 0; i < len; i++) {
            count[arr[i]]++;
        }
        int[] ans = new int[k];
        int n = 0;
        for (int i = 0; i < 10000; i++) {
            for (int j = 0; j < count[i]; j++) {
                if (n == k) {
                    return ans;
                }
                ans[n++] = i;
            }
        }
        return ans;
    }
}