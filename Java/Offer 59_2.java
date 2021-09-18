class MaxQueue {
    private ArrayDeque<Integer> support;
    private ArrayDeque<Integer> queue;
    public MaxQueue() {
        support = new ArrayDeque<Integer>();
        queue = new ArrayDeque<Integer>();
    }
    
    public int max_value() {
        if (queue.size() > 0) {
            return support.peekFirst();
        } else {
            return -1;
        }
    }
    
    public void push_back(int value) {
        while (support.size() > 0 && support.peekLast() < value) {
            support.pollLast();
        }
        queue.offerLast(value);
        support.offerLast(value);
    }
    
    public int pop_front() {
        if (queue.size() > 0) {
            int k = queue.pollFirst();
            if (support.peekFirst() == k) {
                support.pollFirst();
            }
            return k;
        }
        return -1;
    }
}

/**
 * Your MaxQueue object will be instantiated and called as such:
 * MaxQueue obj = new MaxQueue();
 * int param_1 = obj.max_value();
 * obj.push_back(value);
 * int param_3 = obj.pop_front();
 */