class Solution {
    public boolean isValid(String s) {
        char[] stack = new char[10000];
        int top = -1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '{' || c == '[' || c == '(') {
                stack[++top] = c;
            } else if (c == ')') {
                if (top < 0 || stack[top] != '(') {
                    return false;
                }
                top--;
            } else if (c == ']') {
                if (top < 0 || stack[top] != '[') {
                    return false;
                }
                top--;
            } else if (c == '}') {
                if (top < 0 || stack[top] != '{') {
                    return false;
                }
                top--;
            }
        }
        return top == -1;
    }
}
