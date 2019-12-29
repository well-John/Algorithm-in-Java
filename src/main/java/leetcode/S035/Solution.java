package leetcode.S035;

public class Solution {
    public int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target) {
                return i;
            }
        }
        return nums.length - 1;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 3, 5, 7};
        Solution solution = new Solution();
        int i = solution.searchInsert(nums, 5);
        System.out.println(i);

    }
}
