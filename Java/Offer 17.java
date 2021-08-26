class Solution {
    public int[] printNumbers(int n) {
        int count = (int)Math.pow(10, n);
        var ans = new int[count - 1];
        for (int i = 0; i < count - 1; i++) {
            ans[i] = i + 1;
        }
        return ans;
    }
}