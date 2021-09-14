class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        int len = s.length();
        StringBuilder sb = new StringBuilder();
        int i = len - 1, j = i;
        while (i >= 0) {
            while (i >= 0 && s.charAt(i) != ' ') {
                i--;
            }
            sb.append(s, i + 1, j + 1);
            sb.append(' ');
            while (i >= 0 && s.charAt(i) == ' ') {
                i--;
            }
            j = i;
        }
        return sb.toString().trim();
    }
}