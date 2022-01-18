class Solution {
    String res = "11";
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        if (n == 2) {
            return "11";
        }
        for (int i = 2; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            int count = 0;
            int j = 0;
            while (j < res.length()) {
                count = 1;
                char c = res.charAt(j);
                int k;
                for (k = j; k < res.length() - 1 && res.charAt(k) == res.charAt(k + 1); k++) {
                    count++;
                }
                sb.append(count);
                sb.append(c);
                j = k + 1;
            }
            res = sb.toString();
        }
        return res;
    }
}