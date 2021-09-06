class Solution {
    private Set<String> ans = new HashSet<String>();
    private boolean[] visit;
    public String[] permutation(String s) {
        int len = s.length();
        visit = new boolean[len];
        StringBuilder sb = new StringBuilder();
        backtrack(s, sb, 0);
        int ansLen = ans.size();
        String[] result = new String[ansLen];
        return ans.toArray(result);
    }

    public void backtrack(String s, StringBuilder sb, int n) {
        int len = s.length();
        if (n == len) {
            ans.add(sb.toString());
            return;
        }
        for (int i = 0; i < len; i++) {
            if (!visit[i]) {
                visit[i] = true;
                sb.append(s.charAt(i));
                backtrack(s, sb, n + 1);
                sb.deleteCharAt(sb.length() - 1);
                visit[i] = false;
            }
        }
    }
}