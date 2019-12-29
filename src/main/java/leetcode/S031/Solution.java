package leetcode.S031;

import sort.BubbleSort;

import java.util.Arrays;

/**
 * 下一个排列
 */
public class Solution {

    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return;
        }
        int i = nums.length - 2;
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j > 0 && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums,i,j);
        }
        reverse(nums,i+1);
    }
    private void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2};
        Solution solution = new Solution();
        solution.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));


    }

}
