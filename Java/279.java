// nt回溯
class Solution {
    int res = Integer.MAX_VALUE;
    List<Integer> list = new ArrayList();
    public int numSquares(int n) {
        int k = (int)Math.sqrt(n);
        int[] arr = new int[k];
        for (int i = 0; i < k; i++) {
            arr[i] = (k - i) * (k - i);
        }
        myNumSquares(n, arr, 0);
        return res;
    }
    public void myNumSquares(int n, int[] arr, int index) {
        if (n == 0) {
            res = Math.min(res, list.size());
        }
        if (n > 0 && list.size() < res) {
            for (int i = index; i < arr.length; i++) {
                list.add(arr[i]);
                myNumSquares(n - arr[i], arr, i);
                list.remove(list.size() - 1);
            }
        }
    }
}