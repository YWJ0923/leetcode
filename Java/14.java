class Solution {
    public String longestCommonPrefix(String[] strs) {
        int i = 0;
        while (true) {
            if (i >= strs[0].length()) {
                return i == 0 ? "" : strs[0].substring(0, i);
            }
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i >= strs[j].length() || strs[j].charAt(i) != c) {
                    return i == 0 ? "" : strs[j].substring(0, i);
                }
            }
            i++;
        }
    }
}
