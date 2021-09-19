class Solution {
    public int strToInt(String str) {
        str = str.trim();
        long res = 0;
        if (str.length() == 0) {
            return 0;
        }
        int flag = 1, i = 0;
        if (str.charAt(0) == '+') {
            flag = 1;
            i = 1;
        }
        else if (str.charAt(0) == '-') {
            flag = -1;
            i = 1;
        }
        for (; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isDigit(c)) {
                int n = c - '0';
                res = res * 10 + flag * n;
                if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) {
                    return flag == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
            } else {
                return (int)res;
            }
        }
        return (int)res;
    }
}