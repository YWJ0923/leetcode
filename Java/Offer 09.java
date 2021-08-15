class CQueue {
    private ArrayList<Integer> stack1;
    private ArrayList<Integer> stack2;
    public CQueue() {
        stack1 = new ArrayList<Integer>();
        stack2 = new ArrayList<Integer>();
    }
    
    public void appendTail(int value) {
        stack1.add(value);
    }
    
    public int deleteHead() {
        if (stack1.size() == 0 && stack2.size() == 0) {
            return -1;
        }
        else if (stack2.size() == 0) {
            int n = stack1.size();
            for (int i = n - 1; i >= 0; i--) {
                stack2.add(stack1.remove(i));
            }
            return stack2.remove(n - 1);
        }
        else {
            return stack2.remove(stack2.size() - 1);
        }
    }
}

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */