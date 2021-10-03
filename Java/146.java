class LRUCache {
    Map<Integer, Integer> cache;
    List<Integer> queue;
    int capacity;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<Integer, Integer>();
        queue = new ArrayList<Integer>();
    }
    
    public int get(int key) {
        if (cache.containsKey(key)) {
            queue.remove(Integer.valueOf(key));
            queue.add(key);
            return cache.get(key);
        } else {
            return -1;
        }
    }
    
    public void put(int key, int value) {
        if (!cache.containsKey(key) && cache.size() == capacity) {
            cache.remove(queue.get(0));
            queue.remove(0);
        } else if (cache.containsKey(key)) {
            queue.remove(Integer.valueOf(key)); 
        }
        queue.add(key);
        cache.put(key, value);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
