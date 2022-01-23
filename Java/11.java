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

class Solution {
    public int maxArea(int[] height) {
        int res = 0;
        int left = 0, right = height.length - 1;
        while (left < right) {
            res = Math.max((right - left) * Math.min(height[left], height[right]), res);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return res;
    }
}

class Solution {
    public int maxArea(int[] height) {
        int ans = 0;
        int i = 0, j = height.length - 1;
        while (i < j) {
            ans = Math.max(ans, Math.min(height[i], height[j]) * (j - i));
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return ans;
    }
}