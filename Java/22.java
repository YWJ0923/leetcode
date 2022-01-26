class Solution {
    public List<String> generateParenthesis(int n) {
        int open = 0, close = 0;
        StringBuilder sb = new StringBuilder();
        List<String> ans = new ArrayList<>();
        myGenerate(ans, sb, open, close, n);
        return ans;
    }

    public void myGenerate(List<String> ans, StringBuilder sb, int open, int close, int n) {
        if (sb.length() == n * 2) {
            ans.add(sb.toString());
            return;
        } 
        if (open < n) {
            sb.append('(');
            myGenerate(ans, sb, open + 1, close, n);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (close < open) {
            sb.append(')');
            myGenerate(ans, sb, open, close + 1, n);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
