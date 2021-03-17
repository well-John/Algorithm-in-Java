package leetcode.S0215;

import utils.CommonUtils;

/**
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素
 */
public class Solution {

    public int findKthLargest(int[] nums, int k) {
        buildMaxHeap(nums, nums.length);

        int length = nums.length;
        for (int i = length - 1; i > nums.length - k; i--) {
            CommonUtils.swap(nums, 0, i);
            length--;
            heapfiy(nums, 0, length);
        }
        return nums[0];
    }

    public void buildMaxHeap(int[] nums, int length) {
        for (int i = (int) Math.floor(length / 2); i >= 0; i--) {
            heapfiy(nums, i, length);
        }

    }

    private void heapfiy(int[] nums, int i, int length) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        int max = i;
        if (left < length && nums[left] > nums[max]) {
            max = left;
        }

        if (right < length && nums[right] > nums[max]) {
            max = right;
        }

        if (max != i) {
            CommonUtils.swap(nums, max, i);
            heapfiy(nums, max, length);
        }
    }


    public static void main(String[] args) {
        int[] nums = {1, 5, 6, 7, 0, 4, 2, 8};

        int kthLargest = new Solution().findKthLargest(nums, 3);
        System.out.println(kthLargest);

    }

}
