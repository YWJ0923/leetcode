//O(m + n)  O(m + n)
//O(log(m + n))  O(1)

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] arr = new int[nums1.length + nums2.length];
        int i = 0, j = 0, n = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                arr[n++] = nums1[i];
                i++;
            }
            else {
                arr[n++] = nums2[j];
                j++;
            }
        }
        while (i < nums1.length) {
            arr[n++] = nums1[i++];
        }
        while (j < nums2.length) {
            arr[n++] = nums2[j++];
        }
        if ((n & 1) == 1) {
            return arr[(n - 1) / 2];
        }
        else {
            return (arr[n / 2] + arr[n / 2 - 1]) / 2.0;
        }
    }
}