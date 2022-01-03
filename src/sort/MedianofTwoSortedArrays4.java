package sort;

public class MedianofTwoSortedArrays4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l1 = 0, r1 = nums1.length - 1, l2 = 0, r2 = nums2.length - 1;
        return binarySearch(nums1, l1, r1, nums2, l2, r2);
    }

    double binarySearch(int[] nums1, int l1, int r1, int[] nums2, int l2, int r2) {
        int range1 = r1 - l1, range2 = r2 - l2;
        int mid1 = nums1[(l1 + r1) >> 1], mid2 = nums2[(l2 + r2) >> 1];

    }
}
