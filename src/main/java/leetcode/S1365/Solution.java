package leetcode.S1365;

import java.util.Arrays;

public class Solution {

    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int tmp = nums[i];
            int count = 0;
            int j = 0;
            while (j < nums.length) {
                if (i != j) {
                    if (nums[j] < tmp) {
                        count++;
                    }
                }
                j++;
            }
            res[i] = count;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{8,1,2,2,3};
        Solution solution = new Solution();
        int[] current = solution.smallerNumbersThanCurrent(nums);
        System.out.println(Arrays.toString(current));
    }

}
