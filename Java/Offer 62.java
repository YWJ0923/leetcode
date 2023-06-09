class Solution {
    public int lastRemaining(int n, int m) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int i = 0;
        while (list.size() > 1) {
            i = (i + m - 1) % list.size();
            list.remove(i);
        }
        return list.get(0);
    }
}