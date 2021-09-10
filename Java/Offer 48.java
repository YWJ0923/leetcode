class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        if (len == 0) {
            return 0;
        }
        int max = 0;
        Map<Character, Integer> hashMap = new HashMap<Character, Integer>();
        int i, start = -1;
        for (i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (hashMap.containsKey(c)) {
                start = Math.max(start, hashMap.get(c));
            }
            hashMap.put(c, i);
            max = Math.max(max, i - start);
        }
        return max;
    }
}