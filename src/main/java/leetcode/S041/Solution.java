package leetcode.S041;

public class Solution {

    public int firstMissingPositive(int[] nums) {
        //范围为1 ~ length+1
        int length = nums.length;

        for (int i = 1; i <= length + 1; i++) {
            if (!isContain(nums, i)) {
                return i;
            }
        }
        return 0;
    }

    public boolean isContain(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {7,8,9,11,12};
        Solution solution = new Solution();
        int missingPositive = solution.firstMissingPositive(nums);
        System.out.print(missingPositive);

    }
}
