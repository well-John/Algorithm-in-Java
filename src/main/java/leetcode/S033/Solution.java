package leetcode.S033;

public class Solution {

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid = left + (right - left) / 2;

        while (left <= right) {
            if (nums[mid] == target) {
                return mid;
            }
            //证明左边是有序的
            if (nums[left] <= nums[mid]) {
                if (nums[mid] >= target && target >= nums[left]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                //证明右边是升序
                if (nums[mid] <= target && nums[right] >= target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            mid = left + (right - left) / 2;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {5, 1, 3};
        Solution solution = new Solution();
        int search = solution.search(nums, 5);
        System.out.println(search);

    }
}
