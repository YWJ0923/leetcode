class MinStack {
    private int[] stack = new int[20000];
    private int top = -1;
    private int[] minStack = new int[20000];
    /** initialize your data structure here. */
    public MinStack() {

    }
    
    public void push(int x) {
        if (top < 19999) {
            if (top == -1) {
                minStack[top + 1] = x;
            }
            else if (x < minStack[top]) {
                minStack[top + 1] = x;
            }
            else {
                minStack[top + 1] = minStack[top];
            }
            stack[++top] = x;
        }
    }
    
    public void pop() {
        if (top >= 0) {
            top--;
        }
    }
    
    public int top() {
        return stack[top];
    }
    
    public int min() {
        return minStack[top];
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */