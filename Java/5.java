class Solution {
    public String longestPalindrome(String s) {
        int start = 0, end = 0, length = 0;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            for (int j = 1; i - j >= 0 && i + j < len; j++) {
                if (s.charAt(i - j) == s.charAt(i + j)) {
                    if (end - start + 1 < 2 * j + 1) {
                        start = i - j;
                        end = i + j;
                    }
                } else {
                    break;
                }
            }
            if (i < len - 1 && s.charAt(i) == s.charAt(i + 1)) {
                if (end - start + 1 < 2) {
                    start = i;
                    end = i + 1;
                }
                for (int j = 1; i - j >= 0 && i + 1 + j < len; j++) {
                    if (s.charAt(i - j) == s.charAt(i + 1 + j)) {
                        if (end - start + 1 < 2 * j + 2) {
                            start = i - j;
                            end = i + 1 + j;
                        }
                    } else {
                        break;
                    }
                }
            }
        }
        return s.substring(start, end + 1);
    }
}

class Solution {
    public String longestPalindrome(String s) {
        int ansCount = 1;
        int ansBeg = 0, ansEnd = 0;
        int len = s.length();
        int count = 1;
        for (int i = 0; i < len; i++) {
            count = 1;
            for (int j = 1; i - j >= 0 && i + j < len; j++) {
                if (s.charAt(i - j) == s.charAt(i + j)) {
                    count += 2;
                    if (count > ansCount) {
                        ansCount = count;
                        ansBeg = i - j;
                        ansEnd = i + j;
                    }
                } else {
                    break;
                }
            }
            if (i + 1 < len && s.charAt(i) == s.charAt(i + 1)) {
                count = 2;
                if (count > ansCount) {
                    ansCount = count;
                    ansBeg = i;
                    ansEnd = i + 1;
                }
                for (int j = 1; i - j >= 0 && i + j + 1 < len; j++) {
                    if (s.charAt(i - j) == s.charAt(i + j + 1)) {
                        count += 2;
                        if (count > ansCount) {
                            ansCount = count;
                            ansBeg = i - j;
                            ansEnd = i + j + 1;
                        }
                    } else {
                        break;
                    }
                }
            }
        }
        return s.substring(ansBeg, ansEnd + 1);
    }
}
