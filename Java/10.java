class Solution {
    public boolean isMatch(String s, String p) {
        int len1 = s.length(), len2 = p.length();
        if (len2 == 0 || ".*".equals(p)) {
            return true;
        }
        char[] arrs = s.toCharArray(), arrp = p.toCharArray();
        int i = 0, j = 0;
        return myIsMatch(arrs, arrp, len1, len2, i, j);
    }

    public boolean myIsMatch(char[] arrs, char[] arrp, int len1, int len2, int i, int j) {
        if (i == len1 && j == len2) {
            return true;
        }
        if (i != len1 && j == len2) {
            return false;
        }
        if (j < len2 - 1 && arrp[j + 1] == '*') {
            if (i < len1 && arrp[j] == arrs[i] || arrp[j] == '.' && i < len1) {
                return myIsMatch(arrs, arrp, len1, len2, i + 1, j) || myIsMatch(arrs, arrp, len1, len2, i, j + 2) || myIsMatch(arrs, arrp, len1, len2, i + 1, j + 2);
            } else {
                return myIsMatch(arrs, arrp, len1, len2, i, j + 2);
            }
        }
        if (i < len1 && arrp[j] == arrs[i] || arrp[j] == '.' && i < len1) {
            return myIsMatch(arrs, arrp, len1, len2, i + 1, j + 1);
        }
        return false;
    }
}

// "aab" "c*a*b" 想象成c*只能匹配0个或者n个c，匹配不了"a" 所以res[1][2]=false
class Solution {
    public boolean isMatch(String s, String p) {
        int len1 = s.length(), len2 = p.length();
        if (len2 == 0 || ".*".equals(p)) {
            return true;
        }
        char[] arrs = s.toCharArray(), arrp = p.toCharArray();
        int i, j;
        boolean[][] res = new boolean[len1 + 1][len2 + 1];
        res[0][0] = true;
        // 这一步必须要
        for (int k = 2; k <= len2; k++) {
            if (arrp[k - 1] == '*' ) {
                res[0][k] = res[0][k - 2];
            }
        }
        for (i = 1; i <= len1; i++) {
            for (j = 1; j <= len2; j++) {
                if (arrs[i - 1] == arrp[j - 1] || arrp[j - 1] == '.') {
                    res[i][j] = res[i - 1][j - 1];
                } else if (arrp[j - 1] == '*') {
                    if (arrs[i - 1] == arrp[j - 2] || arrp[j - 2] == '.') {
                        res[i][j] = res[i - 1][j] || res[i][j - 2];
                    } else {
                        res[i][j] = res[i][j - 2];
                    }
                }
            }
        }
        return res[len1][len2];
    }
}

// 动态规划
class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 0; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j - 1) == '*') {
                    if (myIsMatch(s, p, i, j - 1)) {
                        dp[i][j] = dp[i - 1][j] || dp[i][j - 2];
                    } else {
                        dp[i][j] = dp[i][j - 2];
                    }
                } else {
                    if (myIsMatch(s, p, i, j)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                }
            }
        }
        return dp[m][n];
    }

    public boolean myIsMatch(String s, String p, int i, int j) {
        if (i == 0) {
            return false;
        }
        if (p.charAt(j - 1) == '.') {
            return true;
        }
        return s.charAt(i - 1) == p.charAt(j - 1);
    }
}

