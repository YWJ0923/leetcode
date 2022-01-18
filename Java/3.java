class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        if (len <= 1) {
            return len;
        }
        Set<Character> set = new HashSet<>();
        int ans = 1;
        int i = 0, j = -1;
        while (i < len) {
            if (i != 0) {
                set.remove(s.charAt(i - 1));
            }
            while (j + 1 < len && !set.contains(s.charAt(j + 1))) {
                set.add(s.charAt(j + 1));
                j++;
            }
            ans = Math.max(ans, j - i + 1);
            i++;
        }
        return ans;
    }
}
