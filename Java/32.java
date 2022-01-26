class Solution {
    public int longestValidParentheses(String s) {
        int len = s.length();
        int ans = 0, tmp = 0, balance = 0;
        int i = 0;
        while (i < len) {
            while (i < len && s.charAt(i) != '(') {
                i++;
            }
            tmp = 0;
            balance = 0;
            for (; i < len; i++) {
                if (s.charAt(i) == '(') {
                    balance++;
                    tmp++;
                } else if (balance > 0) {
                    balance--;
                    tmp++;
                    if (balance == 0) {
                        ans = Math.max(ans, tmp);
                    }
                } else {
                    i++;
                    break;
                }
            }
        }
        i = len - 1;
        while (i >= 0) {
            while (i >= 0 && s.charAt(i) != ')') {
                i--;
            }
            tmp = 0;
            balance = 0;
            for (; i >= 0; i--) {
                if (s.charAt(i) == ')') {
                    balance++;
                    tmp++;
                } else if (balance > 0) {
                    balance--;
                    tmp++;
                    if (balance == 0) {
                        ans = Math.max(ans, tmp);
                    }
                } else {
                    i--;
                    break;
                }
            }
        }
        return ans;
    }
}