class Solution {
    public String reverseLeftWords(String s, int n) {
        char[] arr = s.toCharArray();
        for (int i = 0; i < n / 2; i++) {
            char tmp = arr[i];
            arr[i] = arr[n - i - 1];
            arr[n - i - 1] = tmp;
        }
        for (int i = n, j = arr.length - 1; i < j; i++, j--) {
            char tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
        for (int i = 0, j = arr.length - 1; i < j; i++, j--) {
            char tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
        return new String(arr);
    }
}