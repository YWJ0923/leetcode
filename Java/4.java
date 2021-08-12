//O(m + n)  O(m + n)

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

//O(log(m + n))  O(1)
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l1 = 0, r1 = nums1.length - 1, l2 = 0, r2 = nums2.length - 1;
        int m1, m2;
        while (l1 <= r1 && l2 <= r2) {
            m1 = (l1 + r1) / 2;
            m2 = (l2 + r2) / 2;
            if (nums1[m1] < nums2[m2]) {
                l1 = m1 + 1;
                r2 = m2 - 1;
            }
            else {
                r1 = m1 - 1;
                l2 = m2 + 1;
            }
        }
        
    }
}