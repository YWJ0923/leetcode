class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int i = 0;
        int len = gas.length;
        while (i < len) {
            int sum = 0;
            int count = 0;
            while (count < len) {
                sum += gas[(i + count) % len] - cost[(i + count) % len];
                if (sum < 0) {
                    break;
                }
                count++;
            }
            if (count == len) {
                return i;
            }
            i += count + 1;
        }
        return -1;
    }
}