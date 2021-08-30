class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int len = pushed.length;
        if (len == 0) {
            return true;
        }
        int[] stack = new int[len];
        int top = -1;
        int i = 0, j = 0;
        while (j < len) {
            if (top >= 0 && stack[top] == popped[j]) {
                top--;
                j++;
            }
            else {
                while (i < len && pushed[i] != popped[j]) {
                    stack[++top] = pushed[i];
                    i++;
                }
                if (i == len) {
                    return false;
                }
                i++;
                j++;
            }
        }
        return true;
    } 
}