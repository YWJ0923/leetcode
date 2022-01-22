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

// O(log(m + n))  O(1)
// 转换成找两个有序数组中第k小的数
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length;
        int len = len1 + len2;
        if ((len & 1) == 0) {
            return (getKthElement(nums1, nums2, len / 2) + getKthElement(nums1, nums2, len / 2 + 1)) / 2;
        } else {
            return getKthElement(nums1, nums2, len / 2 + 1);
        }
    }

    public double getKthElement(int[] nums1, int[] nums2, int k) {
        int len1 = nums1.length, len2 = nums2.length;
        int index1 = 0, index2 = 0;
        while (true) {
            if (index1 == len1) {
                return nums2[index2 + k - 1];
            }
            if (index2 == len2) {
                return nums1[index1 + k - 1];
            }
            if (k == 1) {
                return Math.min(nums1[index1], nums2[index2]);
            }
            int newIndex1 = index1, newIndex2 = index2;
            int tmp1 = Math.min(len1 - 1, index1 + k / 2 - 1);
            int tmp2 = Math.min(len2 - 1, index2 + k / 2 - 1);
            if (nums1[tmp1] <= nums2[tmp2]) {
                newIndex1 = tmp1 + 1;
                k -= (newIndex1 - index1);
            } else {
                newIndex2 = tmp2 + 1;
                k -= (newIndex2 - index2);
            }
            index1 = newIndex1;
            index2 = newIndex2;
        }
    }
}