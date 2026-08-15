class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int m = nums1.length;
        int n = nums2.length;

        int[] arr = new int[m + n];

        int i = 0, j = 0, k = 0;

        while (i < m) {
            arr[k++] = nums1[i++];
        }

        while (j < n) {
            arr[k++] = nums2[j++];
        }

        java.util.Arrays.sort(arr);

        int len = arr.length;

        if (len % 2 == 1) {
            return arr[len / 2];
        } else {
            return (arr[len / 2 - 1] + arr[len / 2]) / 2.0;
        }
    }
}