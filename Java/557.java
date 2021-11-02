class Solution {
    public String reverseWords(String s) {
        String[] arr = s.split(" ");
        StringBuilder res = new StringBuilder();
        for (String str : arr) {
            StringBuilder sb = new StringBuilder(str);
            sb.reverse();
            res.append(sb);
            res.append(' ');
        }
        return res.substring(0, res.length() - 1);
    }
}
