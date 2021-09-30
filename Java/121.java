class Solution {
    public int maxProfit(int[] prices) {
        int res = 0, tmpMax = prices[prices.length - 1];
        for (int i = prices.length - 2; i >= 0; i--) {
            if (prices[i] > tmpMax) {
                tmpMax = prices[i];
            }
            res = Math.max(tmpMax - prices[i], res);
        }
        return res;
    }
}
