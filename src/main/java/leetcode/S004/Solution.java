package leetcode.S004;

/**
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 */
public class Solution {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] array = new int[nums1.length + nums2.length];
        int length = nums1.length + nums2.length;

        if (length == 0) {
            return 0.00;
        }

        int idx1 = 0, idx2 = 0, i = 0;
        for (; i < length && idx1 < nums1.length && idx2 < nums2.length; i++) {
            array[i] = nums1[idx1] > nums2[idx2] ? nums2[idx2++] : nums1[idx1++];
        }
        while (idx1 < nums1.length) {
            array[i++] = nums1[idx1++];
        }

        while (idx2 < nums2.length) {
            array[i++] = nums2[idx2++];
        }

        return length % 2 == 0 ? (array[length / 2] + array[length / 2 - 1]) / 2.0 : array[length / 2] / 1.0;
    }

    public static void main(String[] args) {

        int[] nums1 = {0,0};
        int[] nums2 = {0,0};
        Solution solution = new Solution();
        double medianSortedArrays = solution.findMedianSortedArrays(nums1, nums2);
        System.out.println(medianSortedArrays);

    }
}
