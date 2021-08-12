class Solution {
    public String replaceSpace(String s) {
        var str = new StringBuilder();
        int beg = 0;
        int n = s.length();
        for (int i = 0;  i < n; i++) {
            if (s.charAt(i) == ' ') {
                str.append(s.substring(beg, i));
                str.append("%20");
                beg = i + 1;
            }
        }
        if (n >= beg) {
            str.append(s.substring(beg, n));
        }
        return str.toString();
    }
}

class Solution {
    public String replaceSpace(String s) {
        return s.replace(" ", "%20");
    }
}