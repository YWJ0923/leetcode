class Solution {
    public int countSubstrings(String s) {
        int len = s.length();
        char[] arr = new char[len];
        arr = s.toCharArray();
        int res = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j <= len; j++) {
                if (check(arr, i, j)) {
                    res++;
                }
            }
        }
        return res;
    }

    public boolean check(char[] arr, int begin, int end) {
        for (int i = 0; i < (end - begin) / 2; i++) {
            if (arr[begin + i] != arr[end - i - 1]) {
                return false;
            }
        }
        return true;
    }
}
