class Solution {
    public boolean isNumber(String s) {
        int i = 0;
        int len = s.length();
        int end = len - 1;
        for (; i < len && s.charAt(i) == ' '; i++)
            ;
        for (; end >= 0 && s.charAt(end) == ' '; end--)
            ;
        if (i == len) {
            return false;
        }
        if (s.charAt(i) == '+' || s.charAt(i) == '-') {
            i++;
        }
        boolean eFlag = false;
        boolean digitBefore = false;
        boolean pointBefore = false;
        while (i <= end) {
            if (s.charAt(i) == 'e' || s.charAt(i) == 'E') {
                if (eFlag || !digitBefore) {
                    return false;
                }
                eFlag = true;
                if (i == end) {
                    return false;
                }
                if (s.charAt(i + 1) == '+' || s.charAt(i + 1) == '-') {
                    i++;
                    if (i == end) {
                        return false;
                    }
                }
            }
            else if (s.charAt(i) == '.') {
                if (eFlag || pointBefore || i == end && !digitBefore) {
                    return false;
                }
                pointBefore = true;
            }
            else if (!Character.isDigit(s.charAt(i))) {
                return false;
            }
            else {
                digitBefore = true;
            }
            i++;
        }
        if (i > end) {
            return true;
        }
        return false;
    }
}
