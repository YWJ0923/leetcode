class Solution {
    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1;
        int ans = 0, tmp;
        while (i < j) {
            tmp = Math.min(height[i], height[j]) * (j - i);
            if (tmp > ans) {
                ans = tmp;
            }
            if (height[i] < height[j]) {
                i++;
            }
            else {
                j--;
            }
        }
        return ans;
    }
}
