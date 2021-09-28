class Solution {
    public int numTrees(int n) {
        double res = 1;
        for (int i = 1; i <= n; i++) {
            res *= i + n;
            res /= i;
        }
        res /= 1 + n;
        return (int)res;
    }
}
