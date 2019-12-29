package leetcode.S034;

import java.util.Arrays;

public class Solution {

    public int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid = left + (right - left) / 2;
        int[] result = {-1, -1};

        while (left <= right) {
            if (nums[mid] == target) {
                int leftIndex = mid;
                int rightIndex = mid;
                while (leftIndex >= 1 && nums[leftIndex] == nums[leftIndex - 1]) {
                    leftIndex--;
                }
                result[0] = leftIndex;

                while (rightIndex <= nums.length - 2 && nums[rightIndex] == nums[rightIndex + 1]) {
                    rightIndex++;
                }
                result[1] = rightIndex;
                break;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
            mid = left + (right - left) / 2;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1};
        Solution solution = new Solution();
        int[] searchRange = solution.searchRange(nums, 1);
        System.out.println(Arrays.toString(searchRange));
    }
}
