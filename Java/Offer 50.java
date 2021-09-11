class Solution {
    public char firstUniqChar(String s) {
        int len = s.length();
        int[] count = new int[128];
        for (int i = 0; i < len; i++) {
            count[s.charAt(i)]++;
        }
        for (int i = 0; i < len; i++) {
            if (count[s.charAt(i)] == 1) {
                return s.charAt(i);
            }
        }
        return ' ';
    }
}