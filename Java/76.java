class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> needMap = new HashMap<Character, Integer>();
        int needCount = 0;
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (needMap.containsKey(c)) {
                needMap.put(c, needMap.get(c) + 1);
            } else {
                needMap.put(c, 1);
            }
            needCount++;
        }
        int left = 0, right = 0;
        int l = 0, r = -1;
        while (right < s.length()) {
            char c = s.charAt(right);
            if (needMap.containsKey(c)) {
                int n = needMap.get(c);
                needMap.put(c, n - 1);
                if (n > 0) {
                    needCount--;
                }
            }
            if (needCount == 0) {
                for (; left < right; left++) {
                    if (needMap.containsKey(s.charAt(left))) {
                        break;
                    }
                }
                for (; left <= right; left++) {
                    char c2 = s.charAt(left);
                    if (needMap.containsKey(c2) && needMap.get(c2) < 0) {
                        needMap.put(c2, needMap.get(c2) + 1);
                    } else if (needMap.containsKey(c2)) {
                        needMap.put(c2, 1);
                        break;
                    }
                }
                if (right - left < r - l || r - l == -1) {
                    r = right;
                    l = left;
                }
                needCount++;
                left++;
            }
            right++;
        }
        return s.substring(l, r + 1);
    }
}
